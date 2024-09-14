package com.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class PrefixSumTest {
  private PrefixSum testPrefixSum = new PrefixSum();

  @Test
  public void testFindMaxLength() {
    assertEquals(4, testPrefixSum.findMaxLength(new int[] { 0, 1, 1, 0, 1, 1, 1, 0 }));
  }

  @Test
  public void testSubarraySum() {
    assertEquals(2, testPrefixSum.subarraySum(new int[] { 1, 2, 3, 4, 5 }, 9));
  }

  @Test
  public void testSubarrayIdxSum() {
    List<int[]> actual = testPrefixSum.subarrayIdxSum(new int[] { 1, 2, 3, 4, 5 }, 9);
    assertArrayEquals(new int[] { 1, 3 }, actual.get(0));
    assertArrayEquals(new int[] { 3, 4 }, actual.get(1));
  }
}
