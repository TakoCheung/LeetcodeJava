package com.leetcode;

import java.util.HashSet;
import java.util.Set;

import com.leetcode.util.ListNode;

public class FastSlowPointers {

  public boolean hasCycle(ListNode head) {
    if (head == null) {
      return false;
    }
    ListNode hare = head;
    ListNode turtle = head;

    while (hare != null && hare.next != null) {
      hare = hare.next.next;
      turtle = turtle.next;
      if (hare == turtle) {
        return true;
      }
    }
    return false;
  }

  public boolean isHappy(int n) {
    int slow = n;
    int fast = n;
    do {
      slow = isHappyHelper(slow);
      fast = isHappyHelper(isHappyHelper(fast));
    } while (slow != fast);
    return slow == 1;
  }

  public int findDuplicate(int[] nums) {
    int len = nums.length;
    for (int num : nums) {
      int idx = Math.abs(num);
      if (nums[idx] < 0) {
        return idx;
      }
      nums[idx] = -nums[idx];
    }

    return len;
  }

  private int isHappyHelper(int num) {
    int squaredSum = 0;
    while (num > 0) {
      int remainder = num % 10;
      squaredSum += remainder * remainder;
      num /= 10;
    }
    return squaredSum;
  }
}
