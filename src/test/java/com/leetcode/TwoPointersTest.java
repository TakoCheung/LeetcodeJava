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

  @Test
  public void testMaxArea() {
    assertEquals(49, twoPointers.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
  }

  @Test
  public void testTwoSumSorted() {
    assertArrayEquals(new int[] { 1, 2 }, twoPointers.twoSumSorted(new int[] { 2, 7, 11, 15 }, 9));
    assertArrayEquals(new int[] { 1, 2 }, twoPointers.twoSumSorted(new int[] { -1, 0 }, -1));
  }

  @Test
  public void testBinarySearch() {
    assertEquals(-1, twoPointers.binarySearch(new int[] { 2, 7, 11, 15 }, 9));
    assertEquals(2, twoPointers.binarySearch(new int[] { 2, 7, 11, 15 }, 11));
    assertEquals(7,
        twoPointers.binarySearch(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17 }, 8));
    assertEquals(2, twoPointers.binarySearch(new int[] { 1, 2, 2, 4, 5, 5 }, 2));
  }

  @Test
  public void testBinarySearchClosest() {
    assertEquals(3, twoPointers.binarySearchClosest(new int[] { 2, 7, 11, 15 }, 100));
    assertEquals(2, twoPointers.binarySearchClosest(new int[] { 2, 7, 11, 15 }, 12));
    assertEquals(3, twoPointers.binarySearchClosest(new int[] { 2, 7, 11, 15 }, 14));
    assertEquals(0,
        twoPointers.binarySearchClosest(
            new int[] { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170 },
            8));
    assertEquals(3, twoPointers.binarySearchClosest(new int[] { 1, 2, 2, 4, 5, 5 }, 3));
  }

  @Test
  public void testBinarySearchLeftMost() {
    assertEquals(1, twoPointers.binarySearchLeftMost(new int[] { 1, 2, 2, 3 }, 2));
    assertEquals(3, twoPointers.binarySearchLeftMost(new int[] { 1, 2, 2, 4, 5, 5 }, 4));
    assertEquals(3, twoPointers.binarySearchLeftMost(new int[] { 1, 2, 2, 4, 4, 5, 5 }, 4));
    assertEquals(-1,
        twoPointers.binarySearchLeftMost(
            new int[] { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170 },
            8));
    assertEquals(-1, twoPointers.binarySearchLeftMost(new int[] { 1, 2, 2, 4, 5, 5 }, 3));
  }

  @Test
  public void testBinarySearchRightMost() {
    assertEquals(2, twoPointers.binarySearchRightMost(new int[] { 1, 2, 2, 3 }, 2));
    assertEquals(5, twoPointers.binarySearchRightMost(new int[] { 1, 2, 2, 4, 5, 5 }, 5));
    assertEquals(4, twoPointers.binarySearchRightMost(new int[] { 1, 2, 2, 4, 4, 5, 5 }, 4));
    assertEquals(-1,
        twoPointers.binarySearchRightMost(
            new int[] { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170 },
            8));
    assertEquals(-1, twoPointers.binarySearchRightMost(new int[] { 1, 2, 2, 4, 5, 5 }, 3));
  }

  @Test
  public void testFindMin() {
    assertEquals(1, twoPointers.findMin(new int[] { 3, 4, 5, 1, 2 }));
    assertEquals(0, twoPointers.findMin(new int[] { 4, 5, 6, 7, 0, 1, 2 }));
    assertEquals(11, twoPointers.findMin(new int[] { 11, 13, 15, 17 }));
    // assertEquals(-1,
    // twoPointers.binarySearchRightMost(
    // new int[] { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150,
    // 160, 170 },
    // 8));
    assertEquals(1, twoPointers.findMin(new int[] { 3, 1, 2 }));
  }
}
