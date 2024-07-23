package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.leetcode.util.TreeNode;

public class TreeUtil {
  public List<Integer> inorderTraversal(TreeNode root, List<Integer> list) {
    if (root == null)
      return list;
    Stack<TreeNode> stack = new Stack<>();
    while (root != null || !stack.empty()) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      list.add(root.val);
      root = root.right;

    }
    return list;
  }

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

  public int maxDepth(TreeNode root) {
    if (root == null)
      return 0;
    if (root.left == null && root.right == null)
      return 1;
    if (root.right != null)
      return 1 + maxDepth(root.right);
    if (root.left != null)
      return 1 + maxDepth(root.left);
    return Math.max(maxDepth(root.right), maxDepth(root.left)) + 1;
  }

  public boolean isSymmetric(TreeNode root) {
    return isEqual(root.left, root.right);
  }

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> ret = new ArrayList<>();
    if (root != null) {
      ret.add(new ArrayList() {
        {
          add(root.val);
        }
      });
    }
    levelOrderHelper(root.left, root.right, ret, 2);
    return ret;
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

  TreeNode insertIntoBSTHelper(TreeNode temp, int val) {
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

  boolean isEqual(TreeNode node1, TreeNode node2) {
    if (node1 == null && node2 == null) {
      return true;
    }
    if (node1 == null || node2 == null) {
      return false;
    }
    return node1.val == node2.val && isEqual(node1.right, node2.left) && isEqual(node2.right, node1.left);
  }

  void levelOrderHelper(TreeNode left, TreeNode right, List<List<Integer>> ret, int i) {
    ret.get(i).add(left.val);
    ret.get(i).add(right.val);
  }
}
