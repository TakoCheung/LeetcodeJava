package com.leetcode;

class MyHashSet {
  private boolean[] container;

  public MyHashSet() {
    container = new boolean[Integer.MAX_VALUE];
  }

  public void add(int key) {
    container[key] = true;
  }

  public void remove(int key) {
    container[key] = false;
  }

  public boolean contains(int key) {
    return container[key];
  }
}