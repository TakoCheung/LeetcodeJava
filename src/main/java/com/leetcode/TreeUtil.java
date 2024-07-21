package com.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.util.TreeNode;

public class TreeUtil {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    inorderTraversalHelper(root, res);
    return res;
  }

  void inorderTraversalHelper(TreeNode root, List<Integer> res) {
    if (root != null) {
      inorderTraversalHelper(root.left, res);
      res.add(root.val);
      inorderTraversalHelper(root.right, res);
    }
  }
}
