package com.leetcode;

public class TwoPointers {
  public int[] twoSumIterative(int[] numbers, int target) {// O(nlgn)
    for (int i = 0; i < numbers.length; i++) {
      int complement = target - numbers[i];
      for (int j = i + 1; j < numbers.length; j++) {
        if (numbers[j] == complement) {
          return new int[] { ++i, ++j };
        }
      }
    }
    return null;
  }

  public int[] twoSum(int[] numbers, int target) {// O(lgn)
    int left = 0;
    int right = numbers.length - 1;
    while (left < right) {
      int total = numbers[left] + numbers[right];
      if (total == target) {
        return new int[] { left + 1, right + 1 };
      } else if (total > target) {
        right--;
      } else {
        left++;
      }
    }
    return null;
  }
}
