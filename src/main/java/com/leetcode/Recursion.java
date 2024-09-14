package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.leetcode.util.ListNode;
import com.leetcode.util.TreeNode;

public class Recursion {
  public int height = 0;
  public int length = 0;
  public int n = 0;
  public int count = 0;

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> ret = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      List<Integer> currLevel = new ArrayList<>();
      int levelSize = q.size();
      for (int i = 0; i < levelSize; i++) {
        var tmp = q.poll();
        if (tmp.left != null) {
          q.add(root.left);
        }
        if (tmp.right != null) {
          q.add(root.right);
        }
        currLevel.add(tmp.val);
      }
      ret.add(currLevel);
    }
    return ret;
  }

  public void printTriangle(int height) {
    this.height = height;
    printTriangleHelper('#', 1);
  }

  public void printTriangleHelper(Character c, int i) {
    if (i == this.height) {
      print(c, i);
    } else {
      print(c, i);
      printTriangleHelper(c, i + 1);
      print(c, i);
    }
  };

  public void printRectangle(int row, int col) {
    if (row == 1) {
      if (col == 1) {
        System.out.println('.');
      } else {
        System.out.print('.');
        printRectangle(1, col - 1);
      }
    } else {
      printRectangle(1, col);
      printRectangle(row - 1, col);
    }
  }

  public void printRectangle2(int row, int col) {
    if (row == 1) {
      print('.', col);
    } else {
      printRectangle(1, col);
      printRectangle(row - 1, col);
    }
  }

  public void printNthPattern(int n) {
    if (n == 1) {
      print('X', n);
    } else {
      printNthPattern(n - 1);
      print('X', n);
      printNthPattern(n - 1);
    }
  }

  public void printNthPattern2(int n) {
    this.n = n;
    printNthPattern2Helper(1);
  }

  public void printNthPattern2Helper(int i) {
    if (i == n) {
      print('X', i);
    } else {
      // printNthPattern(n-1);
      print('X', i);
      printNthPattern2Helper(i + 1);
    }
  }

  public void print(Character c, int i) {
    for (int j = 0; j < i; j++) {
      System.out.print(c);
    }
    System.out.println();
  }

  public int factorial(int n) {
    if (n == 1) {
      return 1;
    }
    return n * factorial(n - 1);
  }

  public int bunnyEars2(int bunnies) {
    if (bunnies == 0)
      return 0;
    else {
      return (bunnies % 2 == 0) ? bunnyEars2(bunnies - 1) + 3 : bunnyEars2(bunnies - 1) + 2;
    }
  }

  public int sumDigits(int n) {
    if (n < 10)
      return n;
    else
      return sumDigits(n / 10) + n % 10;
  }

  public int count7(int n) {
    if (n == 0)
      return 0;
    if (n % 10 == 7)
      return 1 + count7(n / 10);
    return count7(n / 10);
  }

  public int count8(int n) {
    if (n == 0)
      return 0;
    if (n % 10 == 8) {
      if ((n / 10) % 10 == 8) {
        return count8(n / 10) + 2;
      }
      return count8(n / 10) + 1;
    }
    return count8(n / 10);
  }

  public int powerN(int base, int n) {
    if (n == 0)
      return 1;
    else
      return base * powerN(base, n - 1);
  }

  public int countX(String str) {
    return countXHelper(str, 0);
  }

  public int countXHelper(String str, int idx) {
    if (idx == str.length())
      return 0;
    if (str.charAt(idx) == 'x') {
      return 1 + countXHelper(str, idx + 1);
    }
    return countXHelper(str, idx + 1);
  }

  public int countHi(String str) {
    return countHiHelper(str, 1);
  }

  public int countHiHelper(String str, int i) {
    if (str.length() <= i)
      return 0;
    if (str.charAt(i - 1) == 'h' && str.charAt(i) == 'i') {
      return 1 + countHiHelper(str, i + 1);
    }
    return countHiHelper(str, i + 1);
  }

  public String changeXY(String str) {
    StringBuilder sb = new StringBuilder();
    changeXYHelper(str, 0, sb);
    return sb.toString();
  }

  public StringBuilder changeXYHelper(String str, int idx, StringBuilder sb) {
    if (idx == str.length())
      return sb;
    if (str.charAt(idx) == 'x') {
      sb.append('y');
    } else {
      sb.append(str.charAt(idx));
    }
    return changeXYHelper(str, idx + 1, sb);
  }

  public String changePi(String str) {
    StringBuilder sb = new StringBuilder();
    sb = changePiH(str, 0, sb);
    return sb.toString();
  }

  public StringBuilder changePiH(String str, int idx, StringBuilder sb) {
    if (idx == str.length())
      return sb;
    else if (idx != str.length() - 1 && str.charAt(idx) == 'p' && str.charAt(idx + 1) == 'i') {
      sb.append("3.14");
      idx++;
    } else
      sb.append(str.charAt(idx));
    return changePiH(str, idx + 1, sb);
  }

  public String noX(String str) {
    if (str.length() == 0)
      return "";
    if (str.equals("x"))
      return "";
    return str + noX(str.substring(1));
  }

  public String endX(String str) {
    StringBuilder sb = new StringBuilder(str.length());
    endXHelper(str, 0, sb);
    return sb.toString();
  }

  public StringBuilder endXHelper(String str, int i, StringBuilder sb) {
    if (i >= str.length())
      return sb;
    if (str.charAt(i) == 'x') {
      sb.setCharAt(sb.length() - i - 1, 'x');
    } else {
      sb.append(str.charAt(i));
    }
    return endXHelper(str, i + 1, sb);
  }

  public boolean groupSum(int start, int[] nums, int target) {
    // if (target == 0)
    // return true;
    // if (start >= nums.length)
    // return false;
    // if (target - nums[start] == 0) {
    // return true;
    // }
    // return groupSum(start + 1, nums, target - nums[start]) || groupSum(start + 1,
    // nums, target);
    if (start >= nums.length)
      return target == 0;
    if (groupSum(start + 1, nums, target - nums[start]))
      return true;
    if (groupSum(start + 1, nums, target))
      return true;
    return false;
  }

  public boolean groupSum6(int start, int[] nums, int target) {
    Integer has6 = 0;
    return groupSum6H(start, nums, target, has6);
    // if(start >= nums.length)
    // return target == 0;
    // if(nums[start] == 6)
    // return groupSum6(start+1, nums, target - 6);
    // if(groupSum6(start+1, nums, target - nums[start]))
    // return true;
    // if(groupSum6(start+1, nums, target))
    // return true;
    // return false;
  }

  public boolean groupSum6H(int start, int[] nums, int target, Integer has6) {
    if (start >= nums.length)
      return (target - has6 * 6) == 0;
    if (nums[start] == 6)
      has6++;
    if (groupSum6H(start + 1, nums, target - nums[start], has6))
      return true;
    if (groupSum6H(start + 1, nums, target, has6))
      return true;
    return false;
  }

  // public List<List<Integer>> combinationSum(int[] candidates, int target) {
  // List<List<Integer>> ret = new ArrayList<>();
  // combinationSumH(candidates, 0, target, ret, new ArrayList<>());
  // return ret;
  // }

  // public void combinationSumH(int[] candidates, int idx,int target,
  // List<List<Integer>> ret, List<Integer> sub) {
  // if(target == 0) ret.add(sub);
  // sub = new ArrayList<>();
  // if(){

  // }
  // }
  public List<int[]> twoSum(int[] nums, int target) {
    List<int[]> ret = new ArrayList<>();
    twoSumRecursive(nums, target, 0, ret, new int[2], -1);
    return ret;
  }

  private void twoSumRecursive(int[] nums, int target, int start, List<int[]> ret, int[] comb, int combIndex) {
    if (combIndex == 1 && target == 0) {
      ret.add(comb.clone()); // Add a copy of the current combination
      return;
    }

    if (start >= nums.length || combIndex >= 1) {
      return; // Base case: No more elements or combination is fully formed
    }

    // Choose the current element
    comb[combIndex + 1] = start;
    twoSumRecursive(nums, target - nums[start], start + 1, ret, comb, combIndex + 1);

    // Don't choose the current element, move to the next one
    twoSumRecursive(nums, target, start + 1, ret, comb, combIndex);
  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    makeCombination(candidates, target, 0, new ArrayList<>(), 0, res);
    return res;
  }

  private void makeCombination(int[] candidates, int target, int idx, List<Integer> comb, int total,
      List<List<Integer>> res) {
    if (total == target) {
      res.add(new ArrayList<>(comb));
      return;
      // wrong if no return
    }

    if (total > target || idx >= candidates.length) {
      return;
    }

    comb.add(candidates[idx]);
    makeCombination(candidates, target, idx, comb, total + candidates[idx], res);
    comb.remove(comb.size() - 1);
    makeCombination(candidates, target, idx + 1, comb, total, res);
  }

  public boolean exist(char[][] board, String word) {
    // Iterate through the board to find the starting point
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        return existH(board, word, i, j, 0);
      }
    }
    return false;
  }

  private boolean existH(char[][] board, String word, int i, int j, int wordIndex) {
    // Base case: if the current index matches the length of the word
    if (wordIndex == word.length()) {
      return true; // All characters matched
    }

    // Check boundaries and character match
    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(wordIndex)) {
      return false;
    }

    // Temporarily mark the cell as visited
    char temp = board[i][j];
    board[i][j] = '#';

    // Explore all four possible directions (up, down, left, right)
    boolean found = existH(board, word, i + 1, j, wordIndex + 1) || // Down
        existH(board, word, i - 1, j, wordIndex + 1) || // Up
        existH(board, word, i, j + 1, wordIndex + 1) || // Right
        existH(board, word, i, j - 1, wordIndex + 1); // Left

    // Restore the cell's original value
    board[i][j] = temp;

    return found;
  }

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ret = new ArrayList<>();
    subsetsH(nums, ret, new ArrayList<>(), 0);
    return ret;
  }

  public void subsetsH(int[] nums, List<List<Integer>> ret, List<Integer> comb, int idx) {
    if (idx >= nums.length) {
      ret.add(new ArrayList<>(comb));
      return;
    }
    comb.add(nums[idx]);
    subsetsH(nums, ret, comb, idx + 1);
    comb.remove(comb.size() - 1);
    subsetsH(nums, ret, comb, idx + 1);

  }

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> ret = new ArrayList<>();
    permuteH(nums, ret, new ArrayList<>(), 0);
    return ret;
  }

  public void permuteH(int[] nums, List<List<Integer>> ret, List<Integer> permutation, int idx) {
    if (permutation.size() == nums.length) {
      ret.add(new ArrayList<>(permutation));
    }
    if (idx >= nums.length)
      return;
    permutation.add(nums[idx]);
    permuteH(nums, ret, permutation, idx + 1);
    permutation.remove(permutation.size() - 1);
    permuteH(nums, ret, permutation, idx + 1);
  }

  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head; // Nothing to swap or only one node
    }

    ListNode newHead = head.next; // The second node will be the new head after swapping
    head.next = swapPairs(head.next.next); // Recursive call to swap the rest
    newHead.next = head; // Now swap the current pair

    return newHead;
  }
}
