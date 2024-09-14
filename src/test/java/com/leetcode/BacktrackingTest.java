package com.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class BacktrackingTest {
  private Backtracking backtracking = new Backtracking();

  @Test
  public void testPermutation() {
    assertEquals(new ArrayList<>() {
      {
        add(Arrays.asList(1,2,3));
        add(Arrays.asList(1,3,2));
        add(Arrays.asList(2,1,3));
        add(Arrays.asList(2,3,1));
        add(Arrays.asList(3,1,2));
        add(Arrays.asList(3,2,1));
      }
    }, backtracking.permutation(new int[] { 1, 2, 3 }));
  }

  @Test
  public void testLetterCombinations() {
    assertEquals(new ArrayList<>() {
      {
        add("ad");
        add("ae");
        add("af");
        add("bd");
        add("be");
        add("bf");
        add("cd");
        add("ce");
        add("cf");
      }
    }, "23");
  }

  @Test
  public void testCombination() {
    assertLinesMatch(new ArrayList<>(){{
      add("abc");
      add("ab");
      add("ac");
      add("a");
      add("bc");
      add("b");
      add("c");
      add("");
    }}, backtracking.combination("abc"));
  }
}
