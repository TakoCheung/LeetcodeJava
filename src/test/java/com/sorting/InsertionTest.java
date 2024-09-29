package com.sorting;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.TestUtil;

public class InsertionTest {

  @Test
  public void Sort_CompareWithArraysSort_Sorted() {// MethodName_StateUnderTest_ExpectedBehavior
    int run = 0;
    while (run++ < TestUtil.MAX_TEST_RUN) {
      int[] beingTested = TestUtil.generateRandomArray(100, 10000);
      int[] validator = TestUtil.deepCopy(beingTested);
      Insertion.sort(beingTested);
      Arrays.sort(validator);
      for (int i = 0; i < validator.length; i++) {
        assertTrue(beingTested[i] == validator[i]);
      }
    }
  }

  @Test
  public void Sort_CompareWithMaxSize_Sorted() {// MethodName_StateUnderTest_ExpectedBehavior
    int[] beingTested = TestUtil.generateRandomArray(TestUtil.QUADRATIC_INPUT_SIZE, 10000);
    int[] validator = TestUtil.deepCopy(beingTested);
    Insertion.sort(beingTested);
    Arrays.sort(validator);
    for (int i = 0; i < validator.length; i++) {
      assertTrue(beingTested[i] == validator[i]);
    }
  }
}
