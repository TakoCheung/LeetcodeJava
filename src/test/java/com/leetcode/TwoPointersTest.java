package com.leetcode;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TwoPointersTest {
  private TwoPointers twoPointers = new TwoPointers();
  @Test
  public void testFindMaxLength() {
    assertArrayEquals(new int[]{1,2}, twoPointers.twoSum(new int[] { 2,7,11,15 }, 9));
  }
}
