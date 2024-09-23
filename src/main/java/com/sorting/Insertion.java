package com.sorting;

public class Insertion {// Time: O(n^2) Space:O(1)
  public static void sort(int[] toBeSorted) {
    if (toBeSorted == null || toBeSorted.length < 2)
      return;
    for (int i = 1; i < toBeSorted.length; i++) {
      for (int j = i - 1; j >= 0 && toBeSorted[j] > toBeSorted[j+1]; j--) {
        Util.swap(toBeSorted, j, j+1);
      }
    }
  }
}
