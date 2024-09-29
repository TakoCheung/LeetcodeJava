package com.sorting;

public class Merge {
  /*
   * T(N) = a*T(N/b) + O(N^d)
   * 
   * when log(b,a) > d => O(N^log(b,a))
   * when log(b,a) = d => O(N^d * log(2,N))
   * when log(b,a) < d => O(N^d)
   */
  public static void sort(int[] toBeSorted) {
    if (toBeSorted == null || toBeSorted.length < 1) {
      return;
    }
    divide(toBeSorted, 0, toBeSorted.length - 1);
  }

  private static void divide(int[] toBeSorted, int left, int right) {
    if (left == right) {
      return;
    }
    int mid = left + ((right - left) >> 1);// left + (right - left)/2 | 0 + (toBeSorted.length - 0)/2
    divide(toBeSorted, left, mid);
    divide(toBeSorted, mid + 1, right);
    conquer(toBeSorted, left, mid, right);
  }

  private static void conquer(int[] toBeSorted, int left, int mid, int right) {
    int[] merger = new int[right - left + 1];
    int leftIdx = left;
    int rightIdx = mid + 1;
    int idx = 0;

    while (leftIdx <= mid && rightIdx <= right) {
      merger[idx++] = toBeSorted[leftIdx] <= toBeSorted[rightIdx] ? toBeSorted[leftIdx++] : toBeSorted[rightIdx++];
    }
    while (leftIdx <= mid) {
      merger[idx++] = toBeSorted[leftIdx++];
    }
    while (rightIdx <= right) {
      merger[idx++] = toBeSorted[rightIdx++];
    }
    // System.out.printf("left:%d | right:%d\n", left, right);
    for (idx = 0; idx < merger.length; idx++) {
      // System.out.printf("idx:%d | left:%d | merger[idx]:%d\n", idx, left,
      // merger[idx]);
      toBeSorted[left + idx] = merger[idx];
    }
  }

  public static int sumAllSmaller(int[] toBeCalculated) {
    if (toBeCalculated == null || toBeCalculated.length < 2) {
      return 0;
    }
    return sumAllSmallerDivide(toBeCalculated, 0, toBeCalculated.length - 1);
  }

  private static int sumAllSmallerDivide(int[] toBeCalculated, int left, int right) {
    if (left == right) {
      return 0;
    }
    int mid = left + ((right - left) >> 1);// left + (right - left)/2 | 0 + (toBeSorted.length - 0)/2
    return sumAllSmallerDivide(toBeCalculated, left, mid) +
        sumAllSmallerDivide(toBeCalculated, mid + 1, right) +
        sumAllSmallerConquer(toBeCalculated, left, mid, right);
  }

  private static int sumAllSmallerConquer(int[] toBeCalculated, int left, int mid, int right) {
    int[] merger = new int[right - left + 1];
    int leftIdx = left;
    int rightIdx = mid + 1;
    int idx = 0;
    int res = 0;

    while (leftIdx <= mid && rightIdx <= right) {
      res += toBeCalculated[leftIdx] < toBeCalculated[rightIdx] ? (right - rightIdx + 1) * toBeCalculated[leftIdx] : 0;
      merger[idx++] = toBeCalculated[leftIdx] < toBeCalculated[rightIdx] ? toBeCalculated[leftIdx++]
          : toBeCalculated[rightIdx++];
    }
    while (leftIdx <= mid) {
      merger[idx++] = toBeCalculated[leftIdx++];
    }
    while (rightIdx <= right) {
      merger[idx++] = toBeCalculated[rightIdx++];
    }
    for (idx = 0; idx < merger.length; idx++) {
      toBeCalculated[left + idx] = merger[idx];
    }
    return res;
  }

}