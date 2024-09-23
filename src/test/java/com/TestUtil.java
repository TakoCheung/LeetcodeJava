package com;

import java.util.Random;

public class TestUtil {
  private static final Random random = new Random();
  public static final int QUADRATIC_INPUT_SIZE = 5000;
  public static final int CUBIC_INPUT_SIZE = 500;
  public static final int EXPONENTIAL_INPUT_SIZE = 30;
  public static final int FACTORIAL_INPUT_SIZE = 30;

  public static int[] generateRandomArray(int maxSizeOfArray, int maxValueOfEachElem){
    maxSizeOfArray = maxSizeOfArray +1;
    maxValueOfEachElem = maxValueOfEachElem +1;
    int[] arr = new int[ random.nextInt(maxSizeOfArray +1) ];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = random.nextInt(maxValueOfEachElem);
    }
    return arr;
  }

  public static int[] deepCopy(int[] toBeCopied){
    if (toBeCopied == null) {
      return null;
    }
    int[] deepCopyArr = new int [toBeCopied.length];
    for (int i = 0; i < toBeCopied.length; i++) {
      deepCopyArr[i] = toBeCopied[i];
    }
    return deepCopyArr;
  }
}
