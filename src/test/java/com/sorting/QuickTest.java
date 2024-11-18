package com.sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.TestUtil;

public class QuickTest {
  @Test
  public void Sort_FiveElementArray_Sorted() {// MethodName_StateUnderTest_ExpectedBehavior
    int[] actual = new int[] { 5, 4, 3, 2, 1 };
    Quick.sort(actual);
    assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, actual);
  }

  @Test
  public void Sort_EmptyArray_Sorted() {// MethodName_StateUnderTest_ExpectedBehavior
    int[] actual = new int[] { };
    Quick.sort(actual);
    assertArrayEquals(new int[] { }, actual);
  }

  @Test
  public void Sort_NullArray_Sorted() {// MethodName_StateUnderTest_ExpectedBehavior
    int[] actual = null;
    Quick.sort(actual);
    assertArrayEquals(null, actual);
  }

  @Test
  public void Sort_SingleElementArray_Sorted() {// MethodName_StateUnderTest_ExpectedBehavior
    int[] actual = new int[] { 8 };
    Quick.sort(actual);
    assertArrayEquals(new int[] { 8 }, actual);
  }

  @Test
  public void Sort_TwoElementsArray_Sorted() {// MethodName_StateUnderTest_ExpectedBehavior
    int[] actual = new int[] { 1000, 1 };
    Quick.sort(actual);
    assertArrayEquals(new int[] { 1, 1000 }, actual);
  }

  // @Test
  // public void Sort_CompareWithArraysSort_Sorted() {// MethodName_StateUnderTest_ExpectedBehavior
  //   int run = 0;
  //   while (run++ < TestUtil.MAX_TEST_RUN) {
  //     int[] beingTested = TestUtil.generateRandomArray(TestUtil.NLOGN_INPUT_SIZE, TestUtil.NLOGN_INPUT_SIZE);
  //     int[] validator = TestUtil.deepCopy(beingTested);
  //     Quick.sort(beingTested);
  //     Arrays.sort(validator);
  //     for (int i = 0; i < validator.length; i++) {
  //       assertTrue(beingTested[i] == validator[i]);
  //     }
  //   }
  // }

  @Test
  public void Sort_CompareWithNlogNInputSize_Sorted() {// MethodName_StateUnderTest_ExpectedBehavior
    int[] beingTested = TestUtil.generateRandomArray(TestUtil.NLOGN_INPUT_SIZE, TestUtil.NLOGN_INPUT_SIZE);
    int[] validator = TestUtil.deepCopy(beingTested);
    Quick.sort(beingTested);
    Arrays.sort(validator);
    assertTrue(Arrays.equals(beingTested, validator));
  }
}
