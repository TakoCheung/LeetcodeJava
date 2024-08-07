package com.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class ArraysAndHashingTest {
  private ArraysAndHashing arraysAndHashing = new ArraysAndHashing();
  @Test
  public void testFindKthLargest() {
    assertLinesMatch(Arrays.asList(new String[]{"neet",":","love","you"}), arraysAndHashing.decode(arraysAndHashing.encode(Arrays.asList(new String[]{"neet",":","love","you"}))));
  }

  @Test
  public void testProductExceptSelf() {
    assertArrayEquals(new int[] {24,12,8,6}, arraysAndHashing.productExceptSelf(new int[] {1,2,3,4}));
  }

  @Test
  public void testIsValidSudoku() {
    char[][] board = new char[][]{
      new char[]{'5','3','.','.','7','.','.','.','.'},
      new char[]{'6','.','.','1','9','5','.','.','.'},
      new char[]{'.','9','8','.','.','.','.','6','.'},
      new char[]{'8','.','.','.','6','.','.','.','3'},
      new char[]{'4','.','.','8','.','3','.','.','1'},
      new char[]{'7','.','.','.','2','.','.','.','6'},
      new char[]{'.','6','.','.','.','.','2','8','.'},
      new char[]{'.','.','.','4','1','9','.','.','5'},
      new char[]{'.','.','.','.','8','.','.','7','9'}
    };
    assertTrue(arraysAndHashing.isValidSudoku(board));
    board = new char[][]{
      new char[]{'.','.','4','.','.','.','6','3','.'},
      new char[]{'.','.','.','.','.','.','.','.','.'},
      new char[]{'5','.','.','.','.','.','.','9','.'},
      new char[]{'.','.','.','5','6','.','.','.','.'},
      new char[]{'4','.','3','.','.','.','.','.','1'},
      new char[]{'.','.','.','7','.','.','.','.','.'},
      new char[]{'.','.','.','5','.','.','.','.','.'},
      new char[]{'.','.','.','.','.','.','.','.','.'},
      new char[]{'.','.','.','.','.','.','.','.','.'}
    };
    assertFalse(arraysAndHashing.isValidSudoku(board));
  }
}
