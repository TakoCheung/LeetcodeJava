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
      if (i > 0 && nums[i] == nums[i - 1])
        continue;
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
      } else {
        right--;
      }
      ret = Math.max(area, ret);
    }
    return ret;
  }

  public boolean isPalindrome(String s) {
    var str = s.toLowerCase().replaceAll("[^A-Za-z0-9\\t]", "");
    // System.out.println(str);
    var charArray = str.toCharArray();
    int front = 0;
    int back = charArray.length - 1;
    for (int i = 0; i < charArray.length / 2; i++) {
      // System.out.printf("i:%d | charArray[front]:%c | charArray[back]:%c\n", i,
      // charArray[front], charArray[back]);
      if (charArray[front++] != charArray[back--]) {
        return false;
      }
    }
    return true;
  }

  public int[] twoSumSortedSlow(int[] numbers, int target) {
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

  public int[] twoSumSorted(int[] numbers, int target) {
    int left = 0, right = numbers.length - 1;
    int sum = 0;
    while (left < right) {
      sum = numbers[left] + numbers[right];
      if (sum == target) {
        return new int[] { left + 1, right + 1 };
      }
      if (sum > target) {
        right--;
      } else {
        left++;
      }
    }
    return null;
  }

  public int binarySearch(int[] numbers, int target) {
    int left = 0, right = numbers.length - 1, mid = (left + right) / 2;
    while (left <= right) {
      mid = (left + right) / 2;
      if (numbers[mid] == target) {
        return mid;
      }
      if (numbers[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }

  public int binarySearchClosest(int[] numbers, int target) {
    int left = 0, right = numbers.length - 1;
    while (left + 1 < right) {
      int mid = left + (right - 1) / 2;
      if (numbers[mid] > target) {
        right = mid;
      } else {
        left = mid;
      }
    }
    int rightDiff = Math.abs(numbers[right] - target);
    int leftDiff = Math.abs(target - numbers[left]);
    return rightDiff > leftDiff ? left : right;
  }

  public int binarySearchLeftMost(int[] numbers, int target) {
    int left = 0, right = numbers.length - 1;
    while (left + 1 < right) {
      int mid = left + (right - 1) / 2;
      if (numbers[mid] == target) {
        right = mid;
      } else if (numbers[mid] > target) {
        right = mid;
      } else {
        left = mid;
      }
    }
    if (numbers[left] == target) {
      return left;
    }
    if (numbers[right] == target) {
      return right;
    }
    return -1;
  }

  public int binarySearchRightMost(int[] numbers, int target) {
    int left = 0, right = numbers.length - 1;
    while (left + 1 < right) {
      int mid = left + (right - 1) / 2;
      if (numbers[mid] == target) {
        left = mid;
      } else if (numbers[mid] < target) {
        right = mid;
      } else {
        left = mid;
      }
    }
    if (numbers[right] == target) {
      return right;
    }
    if (numbers[left] == target) {
      return left;
    }
    return -1;
  }

  // 4 5 6 7 1 2 3
  // L M R
  // 5 6 7 1 2 3 4
  // L M R
  // 2 3 4 5 6 7 1
  // L M R
  public int findMin(int[] nums) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;

      if (nums[mid] < nums[right]) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }

    return nums[left];
  }
}
