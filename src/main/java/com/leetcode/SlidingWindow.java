package com.leetcode;

import java.util.Queue;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
    return Math.round(maxAvg * 100000) / 100000.0d;
  }

  public int lengthOfLongestSubstring(String s) {
    Queue<Character> q = new LinkedList<>();
    int ret = 0;
    if (s.isEmpty()) {
      return ret;
    }
    for (char c : s.toCharArray()) {
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

  public int characterReplacement(String s, int k) {
    int charEncounter[] = new int[128];
    int ans = 0;
    int max = 0;
    int start = 0;
    for (int end = 0; end < s.length(); end++) {
      charEncounter[s.charAt(end)]++;
      max = Math.max(max, charEncounter[s.charAt(end)]);

      if (end - start + 1 - max > k) {
        charEncounter[s.charAt(start)]--;
        start++;
      }
      ans = Math.max(ans, end - start + 1);
    }
    return ans;
  }

  // TODO: Reminder
  public String minWindow(String s, String t) {
    if (t.length() > s.length()) {
        return "";
    }
    
    int start = 0, end = 0, minLength = Integer.MAX_VALUE, minStart = 0, allowance = t.length();
    int[] charEncounter = new int[128];
    
    // Initialize the frequency map for the target string
    for (int i = 0; i < t.length(); i++) {
        charEncounter[t.charAt(i)]--;
    }
    
    while (end < s.length()) {
        // Expand the window by moving 'end' to the right
        charEncounter[s.charAt(end)]++;
        if (charEncounter[s.charAt(end)] <= 0) {
            allowance--;
        }
        end++;
        
        // Contract the window by moving 'start' to the right
        while (allowance == 0) {
            if (end - start < minLength) {
                minLength = end - start;
                minStart = start;
            }
            charEncounter[s.charAt(start)]--;
            if (charEncounter[s.charAt(start)] < 0) {
                allowance++;
            }
            start++;
        }
    }
    
    return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
}


  public int maxVowels(String s, int k) {
    Set hashmap = new HashSet<Character>(5) {
      {
        add('a');
        add('e');
        add('i');
        add('o');
        add('u');
      }
    };
    int count = 0;
    int max = 0;
    for (int i = 0; i < k; i++) {
      if (hashmap.contains(s.charAt(i))) {
        count++;
      }
    }
    max = Math.max(count, max);
    for (int end = k; end < s.length(); end++) {
      if (hashmap.contains(s.charAt(end - k))) {
        count--;
      }
      if (hashmap.contains(s.charAt(end))) {
        count++;
      }
      max = Math.max(count, max);
    }
    return max;
  }

  public boolean checkInclusion(String s1, String s2) {
    Map<Character, Integer> checker = new HashMap<>();
    int size = s2.length();
    for (char c : s2.toCharArray()) {
      checker.put(c, 1);
    }
    for (int i = 0; i < s1.length() - size + 1; i++) {
      if (checker(checker, s1.substring(i, size + i).toCharArray(), size)) {
        return true;
      }
    }
    return false;
  }

  private boolean checker(Map<Character, Integer> checker, char[] tmp, int count) {
    for (char c : tmp) {
      if (checker.containsKey(c)) {
        if (checker.get(c) == 1) {
          checker.put(c, 0);
          count--;
        }
      }
    }
    if (count == 0) {
      return true;
    }
    for (char c : checker.keySet()) {
      checker.put(c, 1);
    }
    return false;
  }

  public int longestOnes(int[] nums) {
    int ret = 0, count = 0;
    for (int right = 0; right < nums.length; right++) {
      if (nums[right] == 1) {
        count++;
        ret = Math.max(ret, count);
      } else {
        count = 0;
      }
    }
    return ret;
  }

  public int longestOnes(int[] nums, int size) {
    List<Integer> window = new ArrayList<>();
    int count = 0, max = 0;
    for (int right = 0; right < nums.length; right++) {
      window.add(nums[right]);
      if (nums[right] == 0) {
        count++;
        if (count > size) {
          while (window.removeFirst() == 1) {

          }
          count--;
        }
      }
      max = Math.max(max, window.size());
    }
    return max;
  }

  public int maxPower(String s) {
    int max = 0;
    int combo = 0;
    char prev = '.';
    for (char c : s.toCharArray()) {
      if (prev == c) {
        combo++;
      } else {
        prev = c;
        combo = 1;
      }
      max = Math.max(max, combo);
    }
    return max;
  }

  public int maxSubArray(int[] nums) {
    int maxSum = Integer.MIN_VALUE, sum = 0;
    for (int i : nums) {
      if (sum < 0) {
        sum = i;
      } else {
        sum += i;
      }
      maxSum = Math.max(maxSum, sum);
    }
    return maxSum;
  }

  public int maxTurbulenceSize(int[] arr) {
    if (arr.length < 2) {
      return arr.length;
    }
    int max = 0, currentMax = 1;
    currentMax = arr[0] != arr[1] ? 2 : 1;
    max = currentMax;
    for (int i = 2; i < arr.length; i++) {
      if ((arr[i - 2] > arr[i - 1] && arr[i - 1] < arr[i]) || (arr[i - 2] < arr[i - 1] && arr[i - 1] > arr[i])) {
        currentMax++;
      } else {
        currentMax = arr[i] != arr[i - 1] ? 2 : 1;
      }
      max = Math.max(currentMax, max);
    }
    return max;
  }

}
