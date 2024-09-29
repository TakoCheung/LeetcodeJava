package com.leetcode;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;

public class StringPratice {
  public static void main(String[] args) {
    System.out.println(containsNearbyDuplicate(new int[] { 1, 2, 3, 1 }, 3));
  }

  public int countConsistentStrings(String allowed, String[] words) {
    Set<Character> hs = new HashSet<>();
    int ret = 0;
    for (char c : allowed.toCharArray()) {
      hs.add(c);
    }
    for (String word : words) {
      for (int i = 0; i < word.length(); i++) {
        if (!hs.contains(word.charAt(i)))
          break;
        if (hs.contains(word.charAt(i)) && i == word.length() - 1)
          ret++;
      }
    }
    return ret;
  }

  public int singleNumber(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (!set.add(nums[i])) {
        set.remove(nums[i]);
      }
    }
    for (int num : nums) {
      if (set.contains(num))
        return num;
    }
    return -1;
  }

  public int[] xorQueries(int[] arr, int[][] queries) {
    int[] ret = new int[queries.length];
    for (int i = 0; i < queries.length; i++) {
      for (int j = queries[i][0]; j <= queries[i][1]; j++) {
        ret[i] ^= arr[j];
      }
    }
    return ret;
  }

  /**
   * @param s
   * @param t
   * @return
   */
  public boolean isIsomorphic(String s, String t) {
    Map<Character, Character> hm = new HashMap<>();
    Set<Character> hs = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      char sChar = s.charAt(i);
      char tChar = t.charAt(i);
      Character added = hm.put(sChar, tChar);
      if (added != null && tChar != added) {
        return false;
      }
      if (added == null && !hs.add(tChar)) {
        return false;
      }
      hm.put(sChar, tChar);

    }
    return true;
  }

  public String[] findRestaurant(String[] list1, String[] list2) {
    Map<Integer, List<String>> hm = new HashMap<>();
    for (int i = 0; i < list1.length; i++) {
      for (int j = 0; j < list2.length; j++) {
        int idxSum = i + j;
        if (list1[i].equals(list2[j])) {
          if (!hm.containsKey(idxSum)) {
            hm.put(idxSum, new ArrayList<>());
          }
          hm.get(idxSum).add(list2[j]);
        }
      }
    }
    int min = Integer.MAX_VALUE;
    for (int key : hm.keySet()) {
      min = Math.min(key, min);
    }
    String[] res = new String[hm.get(min).size()];
    return hm.get(min).toArray(res);
  }

  public int firstUniqChar(String s) {
    Map<Character, List<Integer>> hm = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char current = s.charAt(i);
      if (!hm.containsKey(current)) {
        hm.put(current, new ArrayList<>());
      }
      hm.get(current).add(i);
    }
    int min = Integer.MAX_VALUE;
    for (Entry<Character, List<Integer>> entry : hm.entrySet()) {
      if (entry.getValue().size() == 1) {
        min = Math.min(entry.getValue().get(0), min);
      }
    }
    return min == Integer.MAX_VALUE ? -1 : min;
  }

  public static boolean containsNearbyDuplicate(int[] nums, int k) {
    Map<Integer, Integer> hm = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      // System.out.println(nums[i]);
      if (hm.containsKey(nums[i])) {
        // System.out.println(nums[i]);
        if (Math.abs(hm.get(nums[i]) - i) <= k) {
          return true;
        }
      }
      hm.put(nums[i], i);

    }
    return false;
  }

  public String convertDateToBinary(String date) {
    String[] tmp = date.split("-");
    StringBuilder sb = new StringBuilder();
    for (String s : tmp) {
      sb.append(Integer.toBinaryString(Integer.parseInt(s)) + "-");
    }
    sb.deleteCharAt(sb.length());
    return sb.toString();
  }

  public int findMinDifference(List<String> timePoints) {
    int prev = LocalTime.parse(timePoints.get(0)).getMinute() + LocalTime.parse(timePoints.get(0)).getHour() * 60;
    int min = Integer.MAX_VALUE;
    int minTime = Integer.MAX_VALUE;
    for (int i = 1; i < timePoints.size(); i++) {
      int curr = LocalTime.parse(timePoints.get(i)).getMinute() + LocalTime.parse(timePoints.get(0)).getHour() * 60;
      int diff = 3601;
      diff = Math.min(Math.abs(curr - prev), Math.abs(curr - minTime));
      if (diff == 3600)
        diff = 1;
      minTime = Math.min(curr, minTime);
      min = Math.min(min, diff);
    }
    return min;
  }

  public String longestPalindrome(String s) {
    System.out.println(s);
    if (s.equals(new StringBuilder(s).reverse().toString())) {
      return s;
    }

    String left = longestPalindrome(s.substring(1));
    String right = longestPalindrome(s.substring(0, s.length() - 1));

    if (left.length() > right.length()) {
      return left;
    } else {
      return right;
    }
  }
  public int minExtraChar(String s, String[] dictionary) {
    int ret = 0;
    StringBuilder sb = new StringBuilder();
    for (String string : dictionary) {
      sb.append(string);
    }
    return ret;
  }

}
