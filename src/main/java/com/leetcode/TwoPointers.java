package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> ret = new ArrayList<>();
    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) continue;
      int left = i + 1;
      int right = nums.length - 1;
      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        if (sum == 0) {
          List<Integer> triple = new ArrayList<>();
          triple.add(nums[i]);
          triple.add(nums[left]);
          triple.add(nums[right]);
          ret.add(triple);
          while (left < right && nums[left] == nums[left + 1])
            left++;
          while (left < right && nums[right] == nums[right - 1])
            right--;
          left++;
          right--;
        } else if (sum > 0) {
          right--;
        } else {
          left++;
        }
      }
    }
    return ret;
  }

  public int maxArea(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int ret = 0;
    while (left != right) {
      int area = (right - left) * Math.min(height[left], height[right]);
      if (height[right] > height[left]) {
        left++;
      }else{
        right--;
      }
      ret = Math.max(area, ret);
    }
    return ret;
  }
}
