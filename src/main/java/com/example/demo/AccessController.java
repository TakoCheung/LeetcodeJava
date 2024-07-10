package com.example.demo;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccessController {

    @Value("${access.file.path}")
    private String accessFilePath;

    @PostMapping("/admin/addUser")
    public String addUser(@RequestBody Access access, @RequestAttribute User user) throws IOException {
        if (!"admin".equals(user.getRole())) {
            return "Error: Only admins can add users";
        }

        try (FileWriter writer = new FileWriter(accessFilePath, true)) {
            writer.write(access.getUserId() + ":" + String.join(",", access.getResources()) + "
");
        }
        return "User access added successfully";
    }

    @GetMapping("/user/{resource}")
    public String checkAccess(@PathVariable String resource, @RequestAttribute User user) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(accessFilePath));
        for (String line : lines) {
            String[] parts = line.split(":");
            if (parts[0].equals(user.getUserId().toString())) {
                List<String> resources = List.of(parts[1].split(","));
                if (resources.contains(resource)) {
                    return "Access granted";
                }
            }
        }
        return "Access denied";
    }
}
