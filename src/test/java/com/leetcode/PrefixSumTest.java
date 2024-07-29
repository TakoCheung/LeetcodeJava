package com.leetcode;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PrefixSumTest {
  private PrefixSum testPrefixSum = new PrefixSum();

  @Test
  public void testFindMaxLength() {
    assertEquals(4, testPrefixSum.findMaxLength(new int[] { 0, 1, 1, 0, 1, 1, 1, 0 }));
  }

  @Test
  public void testSubarraySum() {
    assertEquals(1, testPrefixSum.subarraySum(new int[] { -1, -1, 1 }, 1));
  }
}
