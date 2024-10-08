package com.sorting;

public class Radix {
  public static void sort(int[] toBeSorted) {
    if (toBeSorted == null || toBeSorted.length < 2) {
      return;
    }
    sort(toBeSorted, 0, toBeSorted.length - 1, maxPlace(toBeSorted));
  }

  private static void sort(int[] toBeSorted, int left, int right, int maxPlace) {
    final int radix = 10;
    int[] bucket = new int[right - left + 1];
    for (int place = 1; place <= maxPlace; place++) {
      int[] occurrenceAt = new int[radix];
      for (int i = left; i <= right; i++) {
        int j = getDigitByPlace(toBeSorted[i], place);
        occurrenceAt[j]++;
      }
      for (int i = 1; i < radix; i++) {
        occurrenceAt[i] = occurrenceAt[i] + occurrenceAt[i-1];
      }

      for (int i = right; i >= left; i--) {
        int j = getDigitByPlace(toBeSorted[i], place);
        bucket[occurrenceAt[j] - 1] = toBeSorted[i];
        occurrenceAt[j]--;
      }
      for (int i = left, j = 0; i <= right; i++, j++) {
        toBeSorted[i] = bucket[j];
      }
    }
  }

  private static int getDigitByPlace(int num, int place) {
    return ((num / ((int) Math.pow(10, place -1))) % 10);
  }

  private static int maxPlace(int[] toBeSorted) {
    int max = Integer.MIN_VALUE;
    for (int value : toBeSorted) {
      max = Math.max(value, max);
    }
    int res = 0;
    while (max != 0) {
      res++;
      max /= 10;
    }
    return res;
  }
}
