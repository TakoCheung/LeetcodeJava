package com.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class HeapTest {
  private Heap heap = new Heap();
  @Test
  public void testFindKthLargest() {
    assertEquals(2, heap.findKthLargest(new int[]{1,1,1,2,2,3}, 2));
  }

  @Test
  public void testTopKFrequent() {
    assertArrayEquals(new int[]{1,2}, heap.topKFrequent(new int[]{1,1,1,2,2,3}, 2));
  }
}
