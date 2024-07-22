package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.leetcode.util.TreeNode;

public class TreeUtil {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    inorderTraversalHelper(root, res);
    return res;
  }

  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    preorderTraversalHelper(root, res);
    return res;
  }

  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    postorderTraversalHelper(root, res);
    return res;
  }

  public boolean isValidBST(TreeNode root) {
    return isValidBSTHelper(root);
  }

  public TreeNode insertIntoBST(TreeNode root, int val) {
    root = insertIntoBSTHelper(root, val);
    return root;
  }

  // helper method
  void inorderTraversalHelper(TreeNode root, List<Integer> res) {
    if (root != null) {
      inorderTraversalHelper(root.left, res);
      res.add(root.val);
      inorderTraversalHelper(root.right, res);
    }
  }

  void preorderTraversalHelper(TreeNode root, List<Integer> res) {
    if (root != null) {
      res.add(root.val);
      preorderTraversalHelper(root.left, res);
      preorderTraversalHelper(root.right, res);
    }
  }

  void postorderTraversalHelper(TreeNode root, List<Integer> res) {
    if (root != null) {
      postorderTraversalHelper(root.left, res);
      postorderTraversalHelper(root.right, res);
      res.add(root.val);
    }
  }

  boolean isValidBSTHelper(TreeNode root) {
    if (root != null) {
      if (root.left != null && root.left.val >= root.val) {
        return false;
      }
      if (root.right != null && root.right.val <= root.val) {
        return false;
      }
      isValidBSTHelper(root.left);
      isValidBSTHelper(root.right);
    }
    return true;
  }

  private TreeNode insertIntoBSTHelper(TreeNode temp, int val) {
    if (temp == null) {
      return new TreeNode(val);
    } else {
      if (temp.val > val)
        temp.left = insertIntoBSTHelper(temp.left, val);
      else
        temp.right = insertIntoBSTHelper(temp.right, val);
    }
    System.gc();
    return temp;
  }
}
