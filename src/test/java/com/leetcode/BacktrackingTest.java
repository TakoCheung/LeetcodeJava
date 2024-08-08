package com.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class BacktrackingTest {
  private Backtracking backtracking = new Backtracking();

  @Test
  public void testPermute() {
    assertEquals(new ArrayList<ArrayList<Integer>>() {
      {
        add(new ArrayList<>() {
          {
            add(1);
            add(2);
            add(3);
          }
        });
        add(new ArrayList<>() {
          {
            add(1);
            add(3);
            add(2);
          }
        });
        add(new ArrayList<>() {
          {
            add(2);
            add(1);
            add(3);
          }
        });
        add(new ArrayList<>() {
          {
            add(2);
            add(3);
            add(1);
          }
        });
        add(new ArrayList<>() {
          {
            add(3);
            add(1);
            add(2);
          }
        });
        add(new ArrayList<>() {
          {
            add(3);
            add(2);
            add(1);
          }
        });
      }
    }, backtracking.permute(new int[] { 1, 2, 3 }));
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
}
