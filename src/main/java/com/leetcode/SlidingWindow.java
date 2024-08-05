package com.leetcode;

import java.util.Queue;
import java.util.LinkedList;

public class SlidingWindow {
  public double findMaxAverage(int[] nums, int k) {
    if (nums.length == 1) {
      return nums[0];
    }
    double sum = 0;
    double maxAvg = Double.NEGATIVE_INFINITY;
    double deK = (double) k;
    for (int i = 0; i < k; i++) {
      sum += nums[i];
    }
    maxAvg = Math.max(maxAvg, sum / deK);
    for (int i = k; i < nums.length; i++) {
      sum = sum - nums[i - k] + nums[i];
      maxAvg = Math.max(maxAvg, sum / deK);
    }
    return Math.round(maxAvg*100000)/100000.0d;
  }

  public int lengthOfLongestSubstring(String s) {
    Queue<String> q = new LinkedList<>();
    int ret = 0;
    if (s.isEmpty()) {
      return ret;
    }
    for (String c : s.split("")) {
      if (q.contains(c)) {
        while (q.contains(c)) {
          q.poll();
        }
      }
      q.add(c);
      ret = Math.max(ret, q.size());
    }
    return ret;
  }

  public int lengthOfLongestSubstring2(String s) {
    int n = s.length();
    int max = 0;
    int charAtIndex[] = new int[128];
    for (int start = 0, end = 0; end < n; end++) {

      int ch = s.charAt(end);
      start = Math.max(charAtIndex[ch], start);
      max = Math.max(max, end - start + 1);
      int currentIndex = end + 1;
      charAtIndex[ch] = currentIndex;
    }
    return max;
  }

  //TODO: Reminder
  public String minWindow(String s, String t) {
    if (t.length() >= s.length()) {
      return "";
    }
    int minStart = 0, start = 0, end = 0, minLength = Integer.MAX_VALUE, charLeft = t.length();
    int charEncounter[] = new int[128];
    for (int i = 0; i < t.length(); i++) {
      charEncounter[t.charAt(i)]++;
    }
    while (end < s.length()) {
      if (charEncounter[s.charAt(end)] > 0) {
        charLeft--;
      }
      charEncounter[s.charAt(end)]--;
      end++;
      while (charLeft == 0) {
        if (end - start < minLength) {
          minStart = start;
          minLength = end - start;
        }
        if(charEncounter[s.charAt(start)] == 0){
          charLeft++;
        }
        charEncounter[s.charAt(start)]++;
        start++;
      }
    }
    return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
  }
}
