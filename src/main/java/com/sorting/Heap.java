package com.sorting;
/*
 * leftChildIndex = 2*currentIndex + 1
 * rightChildIndex = 2*currentIndex + 2
 * parentIndex = (currentIndex-1)/2
 * 
 * Time: O(NlgN) | Space: O(1) | Preserve Order: No
 */
public class Heap {
  public static void sort(int[] toBeSorted) {
    if (toBeSorted == null || toBeSorted.length < 2) {
      return;
    }
    for (int i = 0; i < toBeSorted.length; i++) {//O(n)
      heapInsert(toBeSorted, i);//O(lgN)
    }
    int heapSize = toBeSorted.length;
    Util.swap(toBeSorted, 0, --heapSize);//O(1)
    while (heapSize > 0) {//O(n)
      heapify(toBeSorted, 0, heapSize);//O(lgN)
      Util.swap(toBeSorted, 0, --heapSize);//O(1)
    }
  }

  private static void heapify(int[] toBeSorted, int currentAt, int heapSize) {
    int leftChildIndex = leftChildIndex(currentAt);
    while (leftChildIndex < heapSize) {
      int rightChildIndex = leftChildIndex + 1;
      int indexWithLargerValue = rightChildIndex < heapSize && toBeSorted[rightChildIndex] > toBeSorted[leftChildIndex]
          ? rightChildIndex
          : leftChildIndex;
      indexWithLargerValue = toBeSorted[indexWithLargerValue] > toBeSorted[currentAt] ? indexWithLargerValue
          : currentAt;
      if (indexWithLargerValue == currentAt) {
        break;
      }
      Util.swap(toBeSorted, indexWithLargerValue, currentAt);
      currentAt = indexWithLargerValue;
      leftChildIndex = leftChildIndex(currentAt);
    }
  }

  private static void heapInsert(int[] toBeSorted, int at) {
    while (toBeSorted[at] > toBeSorted[parentIndex(at)]) {
      Util.swap(toBeSorted, at, parentIndex(at));
      at = parentIndex(at);
    }
  }

  private static int parentIndex(int currentAt) {
    return (currentAt - 1) / 2;
  }

  private static int leftChildIndex(int currentAt) {
    return 2 * currentAt + 1;
  }
}
