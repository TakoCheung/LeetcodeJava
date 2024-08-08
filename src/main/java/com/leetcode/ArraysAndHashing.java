package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.Stack;

public class ArraysAndHashing {
  public boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (!set.add(nums[i])) {
        return true;
      }
    }
    return false;
  }

  public boolean isAnagram(String s, String t) {
    int[] tracker = new int[128];

    for (char c : s.toCharArray()) {
      tracker[c]++;
    }
    for (char c : t.toCharArray()) {
      tracker[c]--;
    }
    for (int i = 0; i < tracker.length; i++) {
      if (tracker[i] > 0) {
        return false;
      }
    }
    return true;
  }

  public boolean isValid(String s) {
    var charArray = s.toCharArray();
    var openMatching = new Stack<Character>();
    for (char c : charArray) {
      if (c == '(' || c == '{' || c == '[') {
        openMatching.add(c);
      } else {
        if (openMatching.size() == 0) {
          return false;
        }
        var open = Optional.ofNullable(openMatching.removeLast()).orElse(null);
        System.out.printf("open:%c | close:%c\n", open, c);
        switch (c) {
          case ')':
            if (c == ')' && open != '(') {
              return false;
            }
            break;
          case '}':
            if (c == '}' && open != '{') {
              return false;
            }
            break;
          case ']':
            if (c == ']' && open != '[') {
              return false;
            }
            break;
          default:
            return false;
        }
      }
    }
    return openMatching.size() == 0;
  }

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> numMap = new HashMap<>();
    int n = nums.length;

    for (int i = 0; i < n; i++) {
      int complement = target - nums[i];
      if (numMap.containsKey(complement)) {
        return new int[] { numMap.get(complement), i };
      }
      numMap.put(nums[i], i);
    }

    return null;
  }

  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> ret = new ArrayList<>();
    Map<String, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < strs.length; i++) {
      char[] tmp = strs[i].toCharArray();
      Arrays.sort(tmp);
      String key = String.valueOf(tmp);
      if (!map.containsKey(key)) {
        int idx = Integer.valueOf(i);
        map.put(key, new ArrayList<Integer>() {
          {
            add(idx);
          }
        });
      } else {
        map.get(key).add(i);
      }
    }
    map.forEach((k, v) -> {
      ret.add(new ArrayList<>());
      for (int i = 0; i < v.size(); i++) {
        ret.getLast().add(strs[v.get(i)]);
      }
    });
    return ret;
  }

  public String encode(List<String> strs) {

    String wholeString = strs.stream().reduce((acc, word) -> acc + Character.toString(257) + word).orElse("");
    return wholeString;
  }

  public List<String> decode(String str) {
    String[] ret = str.split(Character.toString(257));
    return Arrays.asList(ret);
  }

  public int[] productExceptSelfWithDiv(int[] nums) {
    int[] answers = new int[nums.length];
    // List<Integer> products = new ArrayList<>();
    // products.add(nums[0]);
    int product = nums[0];
    for (int i = 1; i < nums.length; i++) {
      product *= nums[i];
    }
    for (int i = 0; i < answers.length; i++) {
      answers[i] = product / nums[i];
    }
    return answers;
  }

  public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int pre[] = new int[n];
    int suff[] = new int[n];
    pre[0] = 1;
    suff[n - 1] = 1;

    for (int i = 1; i < n; i++) {
      pre[i] = pre[i - 1] * nums[i - 1];
    }
    for (int i = n - 2; i >= 0; i--) {
      suff[i] = suff[i + 1] * nums[i + 1];
    }

    int ans[] = new int[n];
    for (int i = 0; i < n; i++) {
      ans[i] = pre[i] * suff[i];
    }
    return ans;
  }

  public int longestConsecutiveNlgn(int[] nums) {
    if (nums.length == 0)
      return 0;
    Arrays.sort(nums);

    int count = 1;
    int acc = 1;

    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] + 1 == nums[i + 1]) {
        count++;
        if (acc <= count) {
          acc = count;
        }
      } else if (nums[i] == nums[i + 1]) {
        continue;
      } else {
        count = 1;
      }
    }
    return acc;

  }

  public int LongestConsecutive(int[] nums) {
    Set<Integer> numSet = new HashSet<>();
    for (int num : nums) {
      numSet.add(num);
    }

    int longest = 0;

    for (int num : nums) {
      if (!numSet.contains(num - 1)) {
        int length = 1;
        while (numSet.contains(num + length)) {
          length++;
        }
        longest = Math.max(longest, length);
      }
    }

    return longest;
  }

  public boolean isValidSudoku(char[][] board) {
    List<Map<Character, Integer>> rowCheckers = new ArrayList<>(9);
    List<Map<Character, Integer>> subBoxCheckers = new ArrayList<>(9);
    List<Map<Character, Integer>> colCheckers = new ArrayList<>(9);
    int subBoxIdx = 0;
    for (int rowIdx = 0; rowIdx < board.length; rowIdx++) {
      rowCheckers.add(new HashMap<>(9));
      for (int colIdx = 0; colIdx < board[rowIdx].length; colIdx++) {
        subBoxIdx = rowIdx / 3 * 3 + colIdx / 3;
        if (rowIdx == 0) {
          colCheckers.add(new HashMap<>(9));
          subBoxCheckers.add(new HashMap<>(9));
        }
        if (board[rowIdx][colIdx] != '.') {
          subBoxCheckers.get(subBoxIdx).put(board[rowIdx][colIdx],
              subBoxCheckers.get(subBoxIdx).getOrDefault(board[rowIdx][colIdx], 0) + 1);
          rowCheckers.get(rowIdx).put(board[rowIdx][colIdx],
              rowCheckers.get(rowIdx).getOrDefault(board[rowIdx][colIdx], 0) + 1);
        }
        if (board[colIdx][rowIdx] != '.') {
          colCheckers.get(rowIdx).put(board[colIdx][rowIdx],
              colCheckers.get(rowIdx).getOrDefault(board[colIdx][rowIdx], 0) + 1);
        }
      }
    }
    for (int i = 0; i < board.length; i++) {
      if (!isValidFromCheck(colCheckers.get(i))
          || !isValidFromCheck(subBoxCheckers.get(i))
          || !isValidFromCheck(rowCheckers.get(i))) {
        return false;
      }
    }
    return true;
  }

  private boolean isValidFromCheck(Map<Character, Integer> checker) {
    for (Map.Entry<Character, Integer> entry : checker.entrySet()) {
      if (entry.getValue() > 1) {
        return false;
      } else {
        entry.setValue(0);
      }
    }
    return true;
  }

  public boolean isValidParentheses(String s) {
    var charArray = s.toCharArray();
    var openMatching = new Stack<Character>();
    for (char c : charArray) {
      if (c == '(' || c == '{' || c == '[') {
        openMatching.add(c);
      } else {
        if (openMatching.size() == 0) {
          return false;
        }
        var open = openMatching.removeLast();
        // System.out.printf("open:%c | close:%c\n", open, c);
        switch (c) {
          case ')':
            if (c == ')' && open != '(') {
              return false;
            }
            break;
          case '}':
            if (c == '}' && open != '{') {
              return false;
            }
            break;
          case ']':
            if (c == ']' && open != '[') {
              return false;
            }
            break;
          default:
            return false;
        }
      }
    }
    return openMatching.size() == 0;
  }

}
