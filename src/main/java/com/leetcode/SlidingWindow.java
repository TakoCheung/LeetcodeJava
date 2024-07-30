package com.leetcode;

public class SlidingWindow {
  public double findMaxAverage(int[] nums, int k) {
    if(nums.length == 1){
      return nums[0];
    }
    double sum = 0;
    double maxAvg = Double.NEGATIVE_INFINITY;
    double deK = (double) k;
    for (int i = 0; i < k; i++) {
      sum += nums[i];
    }
    maxAvg = Math.max(maxAvg, sum/deK);
    for (int i = k; i < nums.length; i++) {
      sum = sum - nums[i-k] + nums[i];
      maxAvg = Math.max(maxAvg, sum/deK);
    }
    return maxAvg;
  }
}
