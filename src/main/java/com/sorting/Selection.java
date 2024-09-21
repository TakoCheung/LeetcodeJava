package com.sorting;

public class Selection {
  public static void sort(int[] toBeSorted) {// Space: O(1), Time: O(n)
    if (toBeSorted == null || toBeSorted.length < 2)
      return;
    for (int i = 0; i < toBeSorted.length - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < toBeSorted.length; j++) {
        minIndex = toBeSorted[minIndex] > toBeSorted[j] ? j : minIndex;
      }
      if (i != minIndex)
        swap(toBeSorted, i, minIndex);
    }
  }

  private static void swap(int[] toBeSorted, int i, int j) {
    toBeSorted[i] = toBeSorted[i] ^ toBeSorted[j];
    toBeSorted[j] = toBeSorted[i] ^ toBeSorted[j];
    toBeSorted[i] = toBeSorted[i] ^ toBeSorted[j];
  }
}
