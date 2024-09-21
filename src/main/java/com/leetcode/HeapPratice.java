package com.leetcode;

import java.util.AbstractMap;
import java.util.Map;
import java.util.PriorityQueue;

class HeapPratice {
  PriorityQueue<Integer> heap;
  int k;

  public HeapPratice(int k, int[] nums) {
    this.k = k;
    heap = new PriorityQueue<>((a, b) -> b - a); // Default is min-heap which is what we need here
    for (int num : nums) {
      add(num); // Use the add method to ensure we don't exceed k elements from the start
    }
  }

  public int add(int val) {
    if (heap.size() < k) {
      heap.offer(val);
    } else if (val > heap.peek()) {
      // If val is larger than the smallest in heap, remove the smallest and add val
      heap.poll(); // Remove the smallest
      heap.offer(val);
    }
    // At this point, heap.peek() will always give you the kth largest element
    return heap.peek();
  }

  public int lastStoneWeight(int[] stones) {
    for (int i : stones) {
      heap.add(i);
    }
    while (heap.size() != 1) {
      int largest = heap.poll();
      int larger = heap.poll();
      heap.offer(largest - larger);
    }
    return heap.peek();
  }

  public int[][] kClosest(int[][] points, int k) {
    // Using a max heap to keep the k smallest distances
    PriorityQueue<Map.Entry<Double, int[]>> maxHeap = new PriorityQueue<>(
        (a, b) -> Double.compare(b.getKey(), a.getKey()));

    for (int[] point : points) {
      double dist = Math.sqrt(point[0] * point[0] + point[1] * point[1]);
      // Using point itself for simplicity, but typically you might want to avoid
      // storing the entire point in the heap for efficiency
      maxHeap.offer(new AbstractMap.SimpleEntry<>(dist, point));
      if (maxHeap.size() > k) {
        maxHeap.poll(); // Remove the largest distance if we exceed k elements
      }
    }

    // Extract points from the heap into the result array
    int[][] result = new int[k][2];
    int i = 0;
    while (!maxHeap.isEmpty()) {
      int[] point = maxHeap.poll().getValue();
      result[i][0] = point[0];
      result[i][1] = point[1];
      i++;
    }

    return result;
  }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */