package com.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class ArraysAndHashingTest {
  private ArraysAndHashing arraysAndHashing = new ArraysAndHashing();

  @Test
  public void testFindKthLargest() {
    assertLinesMatch(Arrays.asList(new String[] { "neet", ":", "love", "you" }),
        arraysAndHashing.decode(arraysAndHashing.encode(Arrays.asList(new String[] { "neet", ":", "love", "you" }))));
  }

  @Test
  public void testProductExceptSelf() {
    assertArrayEquals(new int[] { 24, 12, 8, 6 }, arraysAndHashing.productExceptSelf(new int[] { 1, 2, 3, 4 }));
  }

  @Test
  public void testIsValidSudoku() {
    char[][] board = new char[][] {
        new char[] { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
        new char[] { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
        new char[] { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
        new char[] { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
        new char[] { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
        new char[] { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
        new char[] { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
        new char[] { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
        new char[] { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
    };
    assertTrue(arraysAndHashing.isValidSudoku(board));
    board = new char[][] {
        new char[] { '.', '.', '4', '.', '.', '.', '6', '3', '.' },
        new char[] { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
        new char[] { '5', '.', '.', '.', '.', '.', '.', '9', '.' },
        new char[] { '.', '.', '.', '5', '6', '.', '.', '.', '.' },
        new char[] { '4', '.', '3', '.', '.', '.', '.', '.', '1' },
        new char[] { '.', '.', '.', '7', '.', '.', '.', '.', '.' },
        new char[] { '.', '.', '.', '5', '.', '.', '.', '.', '.' },
        new char[] { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
        new char[] { '.', '.', '.', '.', '.', '.', '.', '.', '.' }
    };
    assertFalse(arraysAndHashing.isValidSudoku(board));
  }

  @Test
  public void testIsValid() {
    assertTrue(arraysAndHashing.isValid("[{()}]"));
  }

  @Test
  public void testLongestSubarray() {
    assertEquals(2, arraysAndHashing.longestSubarray(new int[] { 1, 2, 3, 3, 2, 2 }));
  }

  @Test
  public void testMerge() {
    assertArrayEquals(new int[] { 1, 2, 2, 2, 2, 3, 3, 3, 6, 7, 8, 9, 66, 97 },
        arraysAndHashing.merge(new int[] { 1, 2, 3, 3, 2, 2 }, new int[] { 9, 3, 6, 2, 66, 7, 8, 97 }));
  }

  @Test
  public void testRemoveDuplicates() {
    assertEquals(5, arraysAndHashing.removeDuplicates(new int[] { 1, 1, 1, 2, 2, 3 }));
    // assertEquals(9, arraysAndHashing.removeDuplicates(new int[]
    // {1,1,1,2,2,3,3,3,4,4,4,5,5,5,6,6,7,7,8,8,9,9}));
  }

  @Test
  public void testMoveZeroes() {
    int[] expected = new int[] { 1, 4, 12, 0, 0 };
    int[] actual = new int[] { 1, 0, 4, 0, 12 };
    arraysAndHashing.moveZeroes(actual);
    assertArrayEquals(expected, actual);
    // System.out.println(Arrays.toString(actual));
    expected = new int[] { 0 };
    actual = new int[] { 0 };
    arraysAndHashing.moveZeroes(actual);
    assertArrayEquals(expected, actual);
  }

  @Test
  public void testSortColors() {
    int[] expected = new int[] { 0,0,1,1,2,2 };
    int[] actual = new int[] { 2,0,2,1,1,0};
    arraysAndHashing.sortColors(actual);
    assertArrayEquals(expected, actual);
    // System.out.println(Arrays.toString(actual));
    // expected = new int[] { 0 };
    // actual = new int[] { 0 };
    // arraysAndHashing.sortColors(actual);
    // assertArrayEquals(expected, actual);
  }
}
