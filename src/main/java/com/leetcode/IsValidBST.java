package com.leetcode;

import java.util.Stack;

import com.leetcode.util.TreeNode;

public class IsValidBST {

  public boolean isValidBST(TreeNode root) {
    if (root == null){
      System.out.println();
      return true;
    }
    Stack<TreeNode> stack = new Stack<>();
    TreeNode pre = null;
    int iteration = 1;
    while (root != null || !stack.isEmpty()) {
      System.out.printf("%d iteration", iteration++);
      int iterationIn = 1;
      while (root != null) {
        System.out.printf("%d iterationIn", iterationIn++);
        System.out.printf("pushing root inner while: %d \n", root.val);
        stack.push(root);
        root = root.left;
        System.out.printf("updated root with left node: %s \n", root != null ? root.val : "null");
      }
      System.out.printf("current stack size: %d \n", stack.size());
      root = stack.pop();
      System.out.printf("pre.val: %s <= root.val: %d \n", pre != null ? pre.val : "null", root.val);
      if (pre != null && root.val <= pre.val){
        System.out.println();
        return false;
      }
      pre = root;
      root = root.right;
      System.out.printf("pre.val is now: %d | updated root with right node: %s \n", pre.val, root != null ? root.val : "null");

    }
    System.out.println();
    return true;
  }
}