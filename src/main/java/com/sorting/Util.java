package com.sorting;

public class Util {
  public static void swap(int[] toBeSorted, int i, int j) {
    toBeSorted[i] = toBeSorted[i] ^ toBeSorted[j];
    toBeSorted[j] = toBeSorted[i] ^ toBeSorted[j];
    toBeSorted[i] = toBeSorted[i] ^ toBeSorted[j];
  }
}
