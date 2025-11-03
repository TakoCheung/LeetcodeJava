import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Standalone CLI to sort files from a "latest" folder into a YYYY/MM/DD structure.
 *
 * Behavior (per requirements):
 * - Source: a folder named "latest" at the same level as year folders (destination root = parent of latest).
 * - Move (not copy) files out of latest.
 * - Images/videos go to root/YYYY/MM/DD; anything else goes to root/other/.
 * - Date priority: EXIF/Video metadata (if exiftool is available) -> filesystem creation time -> last modified.
 * - Local timezone.
 * - On name collision, add a date suffix "-yyyyMMdd-HHmmss" before extension; if still exists, append increment counter.
 * - Dry-run supported.
 *
 * Usage:
 *   javac src/photos/sorter.java
 *   java -cp src/photos sorter --root /path/to/root --latest-name latest [--dry-run] [--verbose]
 *
 * Defaults:
 *   --root defaults to current working directory (.)
 *   --latest-name defaults to "latest"
 */
public class sorter {

	private static final Set<String> IMAGE_EXT = new HashSet<>(Arrays.asList(
			"jpg", "jpeg", "png", "gif", "bmp", "tif", "tiff", "heic", "heif", "webp"
	));
	private static final Set<String> VIDEO_EXT = new HashSet<>(Arrays.asList(
			"mp4", "mov", "avi", "mkv", "m4v", "hevc", "webm", "mts", "m2ts"
	));

	private static final DateTimeFormatter TS_SUFFIX = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

	private static class Config {
		Path root = Paths.get(".").toAbsolutePath().normalize();
		String latestName = "latest";
		boolean dryRun = false;
		boolean verbose = false;
		boolean recursive = false; // default: only direct children of latest
	}

	public static void main(String[] args) {
		Config cfg = parseArgs(args);
		if (cfg == null) {
			printUsage();
			System.exit(1);
		}

		Path latestDir = cfg.root.resolve(cfg.latestName);
		if (!Files.isDirectory(latestDir)) {
			System.err.println("[ERROR] Latest folder not found: " + latestDir);
			System.exit(2);
		}

		boolean exiftoolAvailable = isExifToolAvailable(cfg);
		if (cfg.verbose) {
			System.out.println("[INFO] Root: " + cfg.root);
			System.out.println("[INFO] Latest: " + latestDir);
			System.out.println("[INFO] exiftool available: " + exiftoolAvailable);
		}

	int moved = 0;
	int deleted = 0;
		int skipped = 0;
		int errors = 0;

		try {
			if (cfg.recursive) {
				try (var stream = Files.walk(latestDir)) {
					for (Path p : (Iterable<Path>) stream::iterator) {
						if (Files.isRegularFile(p, LinkOption.NOFOLLOW_LINKS)) {
							Result r = processOne(p, cfg, exiftoolAvailable);
							moved += r.moved; deleted += r.deleted; skipped += r.skipped; errors += r.errors;
						}
					}
				}
			} else {
				try (DirectoryStream<Path> ds = Files.newDirectoryStream(latestDir)) {
					for (Path p : ds) {
						if (Files.isRegularFile(p, LinkOption.NOFOLLOW_LINKS)) {
							Result r = processOne(p, cfg, exiftoolAvailable);
							moved += r.moved; deleted += r.deleted; skipped += r.skipped; errors += r.errors;
						}
					}
				}
			}
		} catch (IOException e) {
			System.err.println("[ERROR] Failed to iterate latest folder: " + e.getMessage());
			System.exit(3);
		}

		System.out.println(String.format("[SUMMARY] moved=%d deleted=%d skipped=%d errors=%d", moved, deleted, skipped, errors));
	}

	private static void printUsage() {
		System.out.println("Usage: java sorter [--root <dir>] [--latest-name <name>] [--dry-run] [--verbose] [--recursive]");
		System.out.println("  --root <dir>         Root directory containing 'latest' and year folders. Default: current directory");
		System.out.println("  --latest-name <name> Name of the source folder. Default: latest");
		System.out.println("  --dry-run            Preview actions without moving files");
		System.out.println("  --verbose            Extra logs");
		System.out.println("  --recursive          Also process files in subdirectories of 'latest'");
	}

	private static Config parseArgs(String[] args) {
		Config cfg = new Config();
		for (int i = 0; i < args.length; i++) {
			String a = args[i];
			switch (a) {
				case "--root":
					if (i + 1 >= args.length) return null;
					cfg.root = Paths.get(args[++i]).toAbsolutePath().normalize();
					break;
				case "--latest-name":
					if (i + 1 >= args.length) return null;
					cfg.latestName = args[++i];
					break;
				case "--dry-run":
					cfg.dryRun = true;
					break;
				case "--verbose":
					cfg.verbose = true;
					break;
				case "--recursive":
					cfg.recursive = true;
					break;
				case "--help":
				case "-h":
					return null;
				default:
					System.err.println("Unknown argument: " + a);
					return null;
			}
		}
		return cfg;
	}

	private enum Category { IMAGE, VIDEO, OTHER }

	private static class Result { int moved; int deleted; int skipped; int errors; }

	private static Result processOne(Path file, Config cfg, boolean exiftoolAvailable) {
		Result r = new Result();
		try {
			String name = file.getFileName().toString();
			String ext = getExtension(name);
			Category cat = categorize(ext);

			if (cfg.verbose) {
				System.out.println("[INFO] Processing: " + file + " (" + cat + ")");
			}

			// Special rule: delete .aae sidecar files
			if ("aae".equals(ext)) {
				String actionPrefix = cfg.dryRun ? "[DRY-RUN] " : "";
				System.out.println(actionPrefix + "DELETE " + file);
				if (!cfg.dryRun) {
					Files.deleteIfExists(file);
				}
				r.deleted = 1;
				return r;
			}

			Path destDir;
			String baseNameForSuffix;
			ZonedDateTime when = null;

			if (cat == Category.IMAGE || cat == Category.VIDEO) {
				when = resolveDate(file, exiftoolAvailable, cat, cfg);
				if (when == null) {
					// As a last resort, skip to 'other'
					cat = Category.OTHER;
				}
			}

			if (cat == Category.IMAGE || cat == Category.VIDEO) {
				LocalDate d = when.withZoneSameInstant(ZoneId.systemDefault()).toLocalDate();
				String year = String.format("%04d", d.getYear());
				String month = String.format("%02d", d.getMonthValue());
				String day = String.format("%02d", d.getDayOfMonth());
				destDir = cfg.root.resolve(year).resolve(month).resolve(day);
				baseNameForSuffix = when.format(TS_SUFFIX);
			} else {
				destDir = cfg.root.resolve("other");
				// For 'other', use lastModified for potential suffix
				try {
					BasicFileAttributes attrs = Files.readAttributes(file, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
					Instant lm = attrs.lastModifiedTime().toInstant();
					baseNameForSuffix = lm.atZone(ZoneId.systemDefault()).format(TS_SUFFIX);
				} catch (IOException e) {
					baseNameForSuffix = LocalDateTime.now().format(TS_SUFFIX);
				}
			}

			if (!cfg.dryRun) {
				Files.createDirectories(destDir);
			}

			Path destPath = generateDestinationPath(destDir, name, baseNameForSuffix, cfg);
			String actionPrefix = cfg.dryRun ? "[DRY-RUN] " : "";
			System.out.println(actionPrefix + "MOVE " + file + " -> " + destPath);

			if (!cfg.dryRun) {
				moveWithFallback(file, destPath);
			}

			r.moved = 1;
		} catch (Exception e) {
			System.err.println("[ERROR] Failed processing " + file + ": " + e.getMessage());
			r.errors = 1;
		}
		return r;
	}

	private static String getExtension(String filename) {
		int idx = filename.lastIndexOf('.');
		if (idx == -1 || idx == filename.length() - 1) return "";
		return filename.substring(idx + 1).toLowerCase(Locale.ROOT);
	}

	private static Category categorize(String ext) {
		if (IMAGE_EXT.contains(ext)) return Category.IMAGE;
		if (VIDEO_EXT.contains(ext)) return Category.VIDEO;
		return Category.OTHER;
	}

	private static ZonedDateTime resolveDate(Path file, boolean exiftoolAvailable, Category cat, Config cfg) {
		// 1) Try exiftool if available
		if (exiftoolAvailable) {
			try {
				ZonedDateTime dt = readDateWithExifTool(file);
				if (dt != null) return dt;
			} catch (Exception e) {
				if (cfg.verbose) {
					System.out.println("[INFO] exiftool failed for " + file + ": " + e.getMessage());
				}
			}
		}
		// 2) Filesystem creation time
		try {
			BasicFileAttributes attrs = Files.readAttributes(file, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
			FileTime ct = attrs.creationTime();
			if (ct != null) {
				return ct.toInstant().atZone(ZoneId.systemDefault());
			}
		} catch (IOException ignored) {}

		// 3) Last modified time
		try {
			FileTime mt = Files.getLastModifiedTime(file, LinkOption.NOFOLLOW_LINKS);
			if (mt != null) {
				return mt.toInstant().atZone(ZoneId.systemDefault());
			}
		} catch (IOException ignored) {}

		return null;
	}

	private static boolean isExifToolAvailable(Config cfg) {
		try {
			Process p = new ProcessBuilder("exiftool", "-ver")
					.redirectErrorStream(true)
					.start();
			try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
				String out = br.readLine();
				int code = p.waitFor();
				if (cfg.verbose) {
					System.out.println("[INFO] exiftool -ver => exit=" + code + ", firstLine=" + out);
				}
				return code == 0;
			}
		} catch (Exception e) {
			if (cfg.verbose) {
				System.out.println("[INFO] exiftool not found: " + e.getMessage());
			}
			return false;
		}
	}

	private static ZonedDateTime readDateWithExifTool(Path file) throws IOException, InterruptedException {
		// Ask exiftool to print tag values only, in a fixed order, first non-empty wins
		// -s -s -s => values only, no tag names
		// -d => format
		String[] cmd = new String[]{
				"exiftool",
				"-s", "-s", "-s",
				"-d", "%Y-%m-%d %H:%M:%S",
				// Images: DateTimeOriginal, CreateDate; Videos: MediaCreateDate, QuickTime:CreateDate, TrackCreateDate; ModifyDate as fallback
				"-DateTimeOriginal",
				"-CreateDate",
				"-MediaCreateDate",
				"-QuickTime:CreateDate",
				"-TrackCreateDate",
				"-ModifyDate",
				file.toAbsolutePath().toString()
		};
		Process p = new ProcessBuilder(cmd)
				.redirectErrorStream(true)
				.start();
		String firstLine = null;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line != null && !line.trim().isEmpty()) {
					if (firstLine == null) firstLine = line.trim();
				}
			}
		}
		int code = p.waitFor();
		if (code != 0) return null;
		if (firstLine == null || firstLine.isEmpty() || firstLine.equals("-")) return null;
		// Parse as local date-time (no timezone info from exiftool format)
		LocalDateTime ldt = LocalDateTime.parse(firstLine, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		return ldt.atZone(ZoneId.systemDefault());
	}

	private static Path generateDestinationPath(Path destDir, String filename, String dateSuffix, Config cfg) throws IOException {
		Path candidate = destDir.resolve(filename);
		if (!Files.exists(candidate)) return candidate;

		String base;
		String ext;
		int idx = filename.lastIndexOf('.');
		if (idx > 0) {
			base = filename.substring(0, idx);
			ext = filename.substring(idx);
		} else {
			base = filename;
			ext = "";
		}

		// First try with date suffix
		String withDate = base + "-" + dateSuffix + ext;
		candidate = destDir.resolve(withDate);
		if (!Files.exists(candidate)) return candidate;

		// Then add an incrementing counter
		int i = 1;
		while (true) {
			String name = base + "-" + dateSuffix + "-" + i + ext;
			candidate = destDir.resolve(name);
			if (!Files.exists(candidate)) return candidate;
			i++;
		}
	}

	private static void moveWithFallback(Path src, Path dest) throws IOException {
		try {
			Files.move(src, dest);
		} catch (AtomicMoveNotSupportedException e) {
			// Retry without atomic
			Files.move(src, dest, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// Cross-filesystem or other issues: copy then delete
			Files.copy(src, dest, StandardCopyOption.REPLACE_EXISTING);
			Files.delete(src);
		}
	}
}
