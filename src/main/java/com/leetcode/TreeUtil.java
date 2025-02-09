package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

import com.leetcode.util.TreeNode;

public class TreeUtil {
  private boolean isBalanced = true;

  public boolean isBalanced() {
    return this.isBalanced;
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
    int left = maxDepth(root.left);
    int right = maxDepth(root.right);
    if (Math.abs(left - right) > 1) {
      isBalanced = false;
    }
    return Math.max(right, left) + 1;
  }

  public boolean isSymmetric(TreeNode root) {
    return isEqual(root.left, root.right);
  }

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> ret = new ArrayList<>();
    if (root == null) {
      return ret;
    }
    Queue<TreeNode> levelQueue = new LinkedList<>();
    levelQueue.add(root);
    while (!levelQueue.isEmpty()) {
      int levelSize = levelQueue.size();
      List<Integer> currentLevel = new ArrayList<>();
      for (int i = 0; i < levelSize; i++) {
        TreeNode currentNode = levelQueue.poll();
        currentLevel.add(currentNode.val);
        if (currentNode.left != null)
          levelQueue.add(currentNode.left);
        if (currentNode.right != null)
          levelQueue.add(currentNode.right);
      }
      ret.add(currentLevel);
    }
    return ret;
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }
    if (root.val > p.val && root.val > q.val) {
      return lowestCommonAncestor(root.left, p, q);
    }
    if (root.val < p.val && root.val < q.val) {
      return lowestCommonAncestor(root.right, p, q);
    }
    return root;
  }

  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null)
      return null;

    if (root.val > key) {
      root.left = deleteNode(root.left, key);
    } else if (root.val < key) {
      root.right = deleteNode(root.right, key);
    } else {
      if (root.left == null)
        return root.right;
      if (root.right == null)
        return root.left;

      TreeNode rightSmallest = root.right;
      while (rightSmallest.left != null)
        rightSmallest = rightSmallest.left;
      rightSmallest.left = root.left;
      return root.right;
    }
    return root;
  }

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

  boolean isBalanced(TreeNode root) {
    if (root == null)
      return true;
    int left = maxDepth(root.left);
    int right = maxDepth(root.right);
    if (Math.abs(left - right) > 1) {
      return false;
    }
    return isBalanced(root.left) && isBalanced(root.right);
  }

  public Map<String, Object> parseJson(String jsonString) {
    Map<String, Object> parser = new HashMap<>();
    return parseJsonHelper(jsonString, parser);
  }

  public Map<String, Object> parseJsonHelper(String jsonString, Map<String, Object> parser) {
    String[] keyValueStrings = jsonString.split(":");
    if (keyValueStrings.length == 2) {
      parser.put(keyValueStrings[0], keyValueStrings[1]);
    } else {
      parser.put(keyValueStrings[0], parseJsonHelper(keyValueStrings[1], parser));
    }

    return parser;
  }

  public TreeNode invertTree(TreeNode root) {
    invertTreeHelper(root);
    return root;
  }

  public void invertTreeHelper(TreeNode root) {
    if (root == null) {
      return;
    } else {
      TreeNode tmp = root.right;
      root.right = root.left;
      root.left = tmp;
      invertTreeHelper(root.left);
      invertTreeHelper(root.right);
    }
  }

  boolean isSameTree = false;

  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }

    if (p != null && q != null && p.val == q.val) {
      return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    return false;
  }
  
  public List<TreeNode> preorderTraversalIterative(TreeNode root){
    List<TreeNode> linkedList = new ArrayList<>();
    if(root != null){
      Stack<TreeNode> stack = new Stack<>();
      stack.add(root);
      while (!stack.empty()) {
        var temp = stack.pop();
        linkedList.add(temp);
        if (temp.right != null) {
          stack.add(temp.right);
        }
        if (temp.left != null) {
          stack.add(temp.left);
        }
      }
    }
    return linkedList;
  }

  public List<TreeNode> inorderTraversalIterative(TreeNode root){
    List<TreeNode> linkedList = new ArrayList<>();
    if(root != null){
      Stack<TreeNode> stack = new Stack<>();
      while (!stack.empty() || root != null) {
        if (root != null) {
          stack.add(root);
          root = root.left;
        }
        else {
          root = stack.pop();
          linkedList.add(root);
          System.out.println(root.val);
          root = root.right;
        }
      }
    }
    return linkedList;
  }

  public List<TreeNode> postorderTraversalIterative(TreeNode root){
    List<TreeNode> linkedList = new ArrayList<>();
    if(root != null){
      Stack<TreeNode> stack = new Stack<>();
      stack.add(root);
      while (!stack.empty()) {
        var temp = stack.pop();
        linkedList.add(temp);
        if (temp.left != null) {
          stack.add(temp.left);
        }
        if (temp.right != null) {
          stack.add(temp.right);
        }
      }
    }
    return linkedList.reversed();
  }
}
