package com.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class TwoPointersTest {
  private TwoPointers twoPointers = new TwoPointers();

  @Test
  public void testTwoSum() {
    assertArrayEquals(new int[] { 1, 2 }, twoPointers.twoSum(new int[] { 2, 7, 11, 15 }, 9));
  }

  @Test
  public void testThreeSum() {// [[-1,-1,2],[-1,0,1]]
    assertEquals(new ArrayList<ArrayList<Integer>>() {
      {
        add(new ArrayList<>() {
          {
            add(-1);
            add(-1);
            add(2);
          }
        });
        add(new ArrayList<>() {
          {
            add(-1);
            add(0);
            add(1);
          }
        });
      }
    }, twoPointers.threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
  }
}
