package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Backtracking {
  public List<List<Integer>> permutation(int[] nums) {
    List<List<Integer>> ret = new ArrayList<>();
    permuteHelper(ret, new ArrayList<>(), nums);
    return ret;
  }

  private void permuteHelper(List<List<Integer>> ret, List<Integer> permutation, int[] nums) {
    if (permutation.size() == nums.length) {
      ret.add(new ArrayList<>(permutation));
    }
    for (int i = 0; i < nums.length; i++) {
      if (permutation.contains(nums[i]))
        continue; // element already exists, skip
      permutation.add(nums[i]);
      permuteHelper(ret, permutation, nums);
      permutation.remove(permutation.size() - 1);
    }
  }

  public List<String> letterCombinations(String digits) {
    // Map<Character, Character[]> hashmap = new HashMap<>(8) {
    // {
    // put('2', new Character[] { 'a', 'b', 'c' });
    // put('3', new Character[] { 'd', 'e', 'f' });
    // put('4', new Character[] { 'g', 'h', 'i' });
    // put('5', new Character[] { 'j', 'k', 'l' });
    // put('6', new Character[] { 'm', 'n', 'o' });
    // put('7', new Character[] { 'p', 'q', 'r', 's' });
    // put('8', new Character[] { 't', 'u', 'v' });
    // put('9', new Character[] { 'x', 'y', 'z' });
    // }
    // };
    List<String> result = new ArrayList<>();
    // letterCombinationsHelper(hashmap, 0, "", digits, result);
    return result;
  }

  // @SuppressWarnings("unlikely-arg-type")
  // private void letterCombinationsHelper(Map<Character, Character[]> hashmap,
  // int idx, String combination, String digits,
  // List<String> result) {
  // if (combination.length() == digits.length()) {
  // result.add(combination);
  // }
  // for (Character character : hashmap.get(digits.charAt(idx))) {
  // letterCombinationsHelper(hashmap, idx + 1, combination +
  // String.valueOf(character), digits, result);
  // }
  // }
  public List<String> combination(String string) {
    List<String> ret = new ArrayList<>();
    combinationHelper(ret, new StringBuilder(), string, 0);
    return ret;
  }

  public void combinationHelper(List<String> ret, StringBuilder combination, String string, int idx) {
    if (idx == string.length()) {
      ret.add(combination.toString());
    } else {
      combination.append(string.charAt(idx));
      combinationHelper(ret, combination, string, idx + 1);
      combination.deleteCharAt(combination.length()-1);
      combinationHelper(ret, combination, string, idx + 1);
    }
  }
}
