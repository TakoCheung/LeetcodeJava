package com.leetcode;
import java.util.Arrays;

class MyHashMap {
  private int[] container;

  public MyHashMap() {
    container = new int[1000001];
    Arrays.fill(container, -1);
  }

  public void put(int key, int value) {
    container[key] = value;
  }

  public int get(int key) {
    return container[key];
  }

  public void remove(int key) {
    container[key] = -1;
  }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
