package com.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BigOTest {
  private BigO bigO = new BigO();
  @Test
  public void testFactorial() {
    assertEquals(24, bigO.factorial(4));
  }

  @Test
  public void testFibonacci() {
    assertEquals(0, bigO.fibonacci(0));
    assertEquals(1, bigO.fibonacci(1));
    assertEquals(1, bigO.fibonacci(2));
    assertEquals(2, bigO.fibonacci(3));
    assertEquals(3, bigO.fibonacci(4));
    assertEquals(5, bigO.fibonacci(5));
    assertEquals(8, bigO.fibonacci(6));
  }

  @Test
  public void testPrintAllFibonacciNums() {
    assertEquals("0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 ", bigO.printAllFibonacciNums(17));
  }

  @Test
  public void testPrintAllFibonacciNumsFast() {
    assertEquals("0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 ", bigO.printAllFibonacciNumsFast(17));
  }
}
