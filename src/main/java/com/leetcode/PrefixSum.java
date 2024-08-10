package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrefixSum {
  // TODO: reminder
  public int findMaxLength(int[] nums) {
    int N = nums.length;
    int[] mp = new int[2 * N + 2];
    int current = N;
    int result = 0;

    for (int i = 0; i < N; i++) {
      current += (nums[i] << 1) - 1;
      if (current == N) {
        result = i + 1;
      } else if (mp[current] == 0) {
        mp[current] = i + 1;
      } else {
        result = Math.max(result, i - mp[current] + 1);
      }
    }
    return result;
  }

  public int subarraySum(int[] nums, int k) {
    int sum = 0, result = 0;
    Map<Integer, Integer> preSum = new HashMap<>();

    preSum.put(0, 1);
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (preSum.containsKey(sum - k)) {
        result += preSum.get(sum - k);
      }
      preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
    }
    return result;
  }

  public List<int[]> subarrayIdxSum(int[] nums, int k) {
    int sum = 0;
    List<int[]> result = new ArrayList<>();
    Map<Integer, Integer> preSum = new HashMap<>();

    preSum.put(0, 0);
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      int complement = sum - k;
      if (preSum.containsKey(complement)) {
        result.add(new int[]{preSum.get(complement), i});
      }
      preSum.put(sum, i+1);
    }
    return result;
  }
}
