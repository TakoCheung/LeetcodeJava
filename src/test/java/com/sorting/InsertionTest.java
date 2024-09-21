package com.sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import org.junit.jupiter.api.Test;

public class InsertionTest {
  @Test
  public void Sort_FiveElementArray_Sorted() {// MethodName_StateUnderTest_ExpectedBehavior
    int[] actual = new int[] { 5, 4, 3, 2, 1 };
    Insertion.sort(actual);
    assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, actual);
  }

  @Test
  public void Sort_SixElementArray_Sorted() {
    int[] actual = new int[] { 100, 5, 4, 3, 2, 1 };
    Insertion.sort(actual);
    assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 100 }, actual);
  }

  @Test
  public void Sort_NullArray_Sorted() {
    int[] actual = null;
    Insertion.sort(actual);
    assertArrayEquals(null, actual);
  }

  @Test
  public void Sort_TwoElementArray_Sorted() {
    int[] actual = new int[] { 100, 1 };
    Insertion.sort(actual);
    assertArrayEquals(new int[] { 1, 100 }, actual);
  }

  @Test
  public void Sort_ThreSameElementArray_Sorted() {
    int[] actual = new int[] { 101, 100, 100 };
    Insertion.sort(actual);
    assertArrayEquals(new int[] { 100, 100, 101 }, actual);
  }

  @Test
  public void Sort_FiveThousandElementArray_Sorted() {
    Random rand = new Random();
    int limit = 5000;
    int[] actual = new int[limit];
    for (int i = 0; i < limit; i++) {
      actual[i] = i + rand.nextInt(Integer.MAX_VALUE - limit);
    }
    Insertion.sort(actual);
    for (int index = 0; index < actual.length - 1; index++) {
      assertTrue(actual[index] < actual[index + 1]);
    }
  }
}
