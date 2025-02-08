// package com.sorting;

// import static org.junit.jupiter.api.Assertions.assertArrayEquals;
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertTrue;
// import java.util.Arrays;

// import org.junit.jupiter.api.Test;

// import com.TestUtil;

// public class MergeTest {
//   @Test
//   public void Sort_FiveElementArray_Sorted() {// MethodName_StateUnderTest_ExpectedBehavior
//     int[] actual = new int[] { 5, 4, 3, 2, 1 };
//     Merge.sort(actual);
//     assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, actual);
//   }

//   @Test
//   public void Sort_EmptyArray_Sorted() {// MethodName_StateUnderTest_ExpectedBehavior
//     int[] actual = new int[] { };
//     Merge.sort(actual);
//     assertArrayEquals(new int[] { }, actual);
//   }

//   @Test
//   public void Sort_NullArray_Sorted() {// MethodName_StateUnderTest_ExpectedBehavior
//     int[] actual = null;
//     Merge.sort(actual);
//     assertArrayEquals(null, actual);
//   }

//   @Test
//   public void Sort_SingleElementArray_Sorted() {// MethodName_StateUnderTest_ExpectedBehavior
//     int[] actual = new int[] { 8 };
//     Merge.sort(actual);
//     assertArrayEquals(new int[] { 8 }, actual);
//   }

//   @Test
//   public void Sort_TwoElementsArray_Sorted() {// MethodName_StateUnderTest_ExpectedBehavior
//     int[] actual = new int[] { 1000, 1 };
//     Merge.sort(actual);
//     assertArrayEquals(new int[] { 1, 1000 }, actual);
//   }

//   // @Test
//   // public void Sort_CompareWithArraysSort_Sorted() {// MethodName_StateUnderTest_ExpectedBehavior
//   //   int run = 0;
//   //   while (run++ < TestUtil.MAX_TEST_RUN) {
//   //     int[] beingTested = TestUtil.generateRandomArray(TestUtil.NLOGN_INPUT_SIZE, TestUtil.NLOGN_INPUT_SIZE);
//   //     int[] validator = TestUtil.deepCopy(beingTested);
//   //     Merge.sort(beingTested);
//   //     Arrays.sort(validator);
//   //     for (int i = 0; i < validator.length; i++) {
//   //       assertTrue(beingTested[i] == validator[i]);
//   //     }
//   //   }
//   // }

//   @Test
//   public void Sort_CompareWithNlogNInputSize_Sorted() {// MethodName_StateUnderTest_ExpectedBehavior
//     int[] beingTested = TestUtil.generateRandomArray(TestUtil.NLOGN_INPUT_SIZE, TestUtil.NLOGN_INPUT_SIZE);
//     int[] validator = TestUtil.deepCopy(beingTested);
//     Merge.sort(beingTested);
//     Arrays.sort(validator);
//     assertTrue(Arrays.equals(beingTested, validator));
//   }

//   @Test
//   public void sumAllSmaller_FiveElementArray_Returned() {// MethodName_StateUnderTest_ExpectedBehavior
//     assertEquals(16, Merge.sumAllSmaller(new int[] { 1, 3, 4, 2, 5 }));
//   }

//   @Test
//   public void Sort_SixElementArray_Sorted() {// MethodName_StateUnderTest_ExpectedBehavior
//     assertEquals(35, Merge.sumAllSmaller(new int[] { 1,2,3,4,5,6 }));
//   }
// }
