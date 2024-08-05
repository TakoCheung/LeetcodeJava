package com.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class FastSlowPointersTest {
  private FastSlowPointers hareTurtle = new FastSlowPointers();
  @Test
  public void testMaxArea() {
    assertTrue( hareTurtle.isHappy(19));
    assertFalse( hareTurtle.isHappy(2));
  }

  @Test
  public void testFindDuplicate() {
    assertEquals( 2, hareTurtle.findDuplicate(new int[]{1,3,4,2,2}));
    assertEquals( 2, hareTurtle.findDuplicate(new int[]{2,1,2}));
    assertEquals( 1, hareTurtle.findDuplicate(new int[]{1,1}));
  }
}
