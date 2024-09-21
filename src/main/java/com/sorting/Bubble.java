package com.sorting;

public class Bubble {
  public static void sort(int[] toBeSorted) {//Time O(n^2) Space O(1)
    if (toBeSorted == null || toBeSorted.length < 2)
      return;
    for (int i = toBeSorted.length - 1; i > 0; i--) {
      for (int j = 0; j < i; j++) {
        if (toBeSorted[j] > toBeSorted[j + 1]) {
          Util.swap(toBeSorted, j, j + 1);
        }
      }
    }
  }
}
