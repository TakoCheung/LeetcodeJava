package com.sorting;

public class Util {
  public static void swap(int[] toBeSorted, int i, int j) {
    if (i != j) {
      toBeSorted[i] = toBeSorted[i] ^ toBeSorted[j];
      toBeSorted[j] = toBeSorted[i] ^ toBeSorted[j];
      toBeSorted[i] = toBeSorted[i] ^ toBeSorted[j];
    }
  }

  public static void conquer(int[] toBeSorted, int start, int mid, int end) {
    int[] merger = new int[end - start + 1];
    int leftIdx = start;
    int rightIdx = mid + 1;
    int idx = 0;

    while (leftIdx <= mid && rightIdx <= end) {
      merger[idx++] = toBeSorted[leftIdx] <= toBeSorted[rightIdx] ? toBeSorted[leftIdx++] : toBeSorted[rightIdx++];
    }
    while (leftIdx <= mid) {
      merger[idx++] = toBeSorted[leftIdx++];
    }
    while (rightIdx <= end) {
      merger[idx++] = toBeSorted[rightIdx++];
    }
    // System.out.printf("left:%d | right:%d\n", left, right);
    for (idx = 0; idx < merger.length; idx++) {
      // System.out.printf("idx:%d | left:%d | merger[idx]:%d\n", idx, left,
      // merger[idx]);
      toBeSorted[start + idx] = merger[idx];
    }
  }
}
