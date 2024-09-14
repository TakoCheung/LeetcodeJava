package com.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class RecursionTest {
  Recursion recursion = new Recursion();

  @Test
  public void testPrintTriangle() {
    recursion.printTriangle(5);
  }

  @Test
  public void testPrintRectangle() {
    recursion.printRectangle(5, 8);
  }

  @Test
  public void testPrintNthPattern() {
    recursion.printNthPattern(5);
  }

  @Test
  public void testPrintNthPattern2() {
    recursion.printNthPattern2(5);
  }

  @Test
  public void testFactorial() {
    assertEquals(120, recursion.factorial(5));
  }

  @Test
  public void testCount7() {
    assertEquals(2, recursion.count7(717));
  }

  @Test
  public void testCount8() {
    assertEquals(4, recursion.count8(8818));
    assertEquals(7, recursion.count8(8888));
  }

  @Test
  public void testChangePi() {
    // assertEquals("hip", recursion.changePi("hip"));
    // assertEquals("xxx3.14xx3.14", recursion.changePi("xxxpixxpi"));
  }

  @Test
  public void testGroupSum() {
    assertTrue(recursion.groupSum(0, new int[] { 2, 4, 8 }, 10));
    assertFalse(recursion.groupSum(0, new int[] { 2, 4, 8 }, 9));
  }

  @Test
  public void testTwoSum() {
    var actual = recursion.twoSum(new int[] { 2, 4, 5, 7, 11, 15 }, 9);
    assertArrayEquals(new int[] { 0, 3 }, actual.get(0));
    assertArrayEquals(new int[] { 1, 2 }, actual.get(1));
  }

  @Test
  public void testWordSearch() {
    char[][] board = new char[][] {
      {'A', 'B', 'C', 'E'},
      {'S', 'F', 'C', 'S'},
      {'A', 'D', 'E', 'E'}
    };
    // assertTrue(recursion.exist(board, "ABCCED"));
    // assertTrue(recursion.exist(board, "SEE"));
  }

  @Test
  public void testSubsets() {
    var actual = recursion.subsets(new int[] { 1, 2, 3});
    assertArrayEquals(new int[] { 1,2,3 }, actual.get(0).stream().mapToInt(Integer::intValue).toArray());
  }
}
