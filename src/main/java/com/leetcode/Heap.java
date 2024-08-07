package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Heap {
  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    for (int i = 0; i < nums.length; i++) {
      heap.add(nums[i]);
    }
    for (int i = 0; i < nums.length - k; i++) {
      heap.poll();
    }
    return heap.peek();
  }

  public int[] topKFrequent(int[] nums, int k) {
    // build the haspmap with key is the number and value is the frequency of the
    // num
    Map<Integer, Integer> numFrequencyMap = new HashMap<>();
    for (int n : nums) {
      numFrequencyMap.put(n, numFrequencyMap.getOrDefault(n, 0) + 1);
    }
    // sort them untilizing the heap
    PriorityQueue<Map.Entry<Integer, Integer>> topKElements = new PriorityQueue<>(
        (e1, e2) -> e2.getValue() - e1.getValue());
    for (Map.Entry<Integer, Integer> entry : numFrequencyMap.entrySet()) {
      topKElements.add(entry);
    }

    int[] topNumbers = new int[k];
    for (int i = 0; i < k; i++) {
      topNumbers[i] = topKElements.poll().getKey();
    }
    return topNumbers;
  }

  private class KeyValue implements Comparable<KeyValue> {
    private int value = 0;
    private int key = 0;

    public KeyValue(int key) {
      this.key = key;
    }

    public KeyValue(int key, int val) {
      this.key = key;
      this.value = val;
    }

    public void seen() {
      value++;
    }

    public int getValue() {
      return value;
    }

    public int getKey() {
      return key;
    }

    @Override
    public int compareTo(KeyValue other) {
      return this.getValue() - other.getValue();
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null || getClass() != obj.getClass())
        return false;
      Integer key = (Integer) obj;
      boolean isEqual = this.getKey() == key;
      if (isEqual) {
        this.seen();
      }
      return isEqual;
    }
  }

}
