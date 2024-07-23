package com.leetcode;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.leetcode.util.TreeNode;

public class TreeUtilTest {

  @Test
  public void testInorderTraversal() {
    TreeUtil treeUtil = new TreeUtil();
    
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.right = new TreeNode(3);
    assertArrayEquals(new int []{1,2,3}, treeUtil.inorderTraversal(root).stream().mapToInt(i -> i).toArray());
  }

  @Test
  public void testPreorderTraversal() {
    TreeUtil treeUtil = new TreeUtil();
    
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.right = new TreeNode(3);
    assertArrayEquals(new int []{2,1,3}, treeUtil.preorderTraversal(root).stream().mapToInt(i -> i).toArray());
  }

  @Test
  public void testPostorderTraversal() {
    TreeUtil treeUtil = new TreeUtil();
    
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.right = new TreeNode(3);
    assertArrayEquals(new int []{1,3,2}, treeUtil.postorderTraversal(root).stream().mapToInt(i -> i).toArray());
  }

  @Test
  public void testValidBST() {
    TreeUtil treeUtil = new TreeUtil();
    
    // Test Case 1: Valid BST
    TreeNode root1 = new TreeNode(2);
    root1.left = new TreeNode(1);
    root1.right = new TreeNode(3);
    assertTrue(treeUtil.isValidBST(root1), "Test Case 1 Failed");
    
    // Test Case 2: Invalid BST (left child greater than root)
    TreeNode root2 = new TreeNode(5);
    root2.left = new TreeNode(6);
    root2.right = new TreeNode(7);
    assertFalse(treeUtil.isValidBST(root2), "Test Case 2 Failed");
    
    // Test Case 3: Invalid BST (right child less than root)
    TreeNode root3 = new TreeNode(10);
    root3.left = new TreeNode(5);
    root3.right = new TreeNode(4);
    assertFalse(treeUtil.isValidBST(root3), "Test Case 3 Failed");
    
    // Test Case 4: Valid BST (single node)
    TreeNode root4 = new TreeNode(1);
    assertTrue(treeUtil.isValidBST(root4), "Test Case 4 Failed");
    
    // Test Case 5: Valid BST (larger tree)
    TreeNode root5 = new TreeNode(8);
    root5.left = new TreeNode(3);
    root5.right = new TreeNode(10);
    root5.left.left = new TreeNode(1);
    root5.left.right = new TreeNode(6);
    root5.left.right.left = new TreeNode(4);
    root5.left.right.right = new TreeNode(7);
    root5.right.right = new TreeNode(14);
    root5.right.right.left = new TreeNode(13);
    assertTrue(treeUtil.isValidBST(root5), "Test Case 5 Failed");
  }

  @Test
  public void testInsertIntoBST() {
    TreeUtil treeUtil = new TreeUtil();
    
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    root.right = new TreeNode(7);
    treeUtil.insertIntoBST(root, 5);
    assertArrayEquals(new int []{1,2,3,4,5,7}, treeUtil.inorderTraversal(root).stream().mapToInt(i -> i).toArray());

    TreeNode root1 = new TreeNode(40);
    root1.left = new TreeNode(20);
    root1.left.left = new TreeNode(10);
    root1.left.right = new TreeNode(30);
    root1.right = new TreeNode(60);
    root1.right.left = new TreeNode(50);
    root1.right.right = new TreeNode(70);
    treeUtil.insertIntoBST(root1, 25);
    assertArrayEquals(new int []{10,20,25,30,40,50,60,70}, treeUtil.inorderTraversal(root1).stream().mapToInt(i -> i).toArray());
  }

  @Test
  public void testMaxDepth() {
    TreeUtil treeUtil = new TreeUtil();
    
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    root.right = new TreeNode(7);
    assertEquals(2, treeUtil.maxDepth(root));

    TreeNode root1 = new TreeNode(40);
    root1.left = new TreeNode(20);
    root1.left.left = new TreeNode(10);
    root1.left.right = new TreeNode(30);
    root1.right = new TreeNode(60);
    root1.right.left = new TreeNode(50);
    root1.right.right = new TreeNode(70);
    assertEquals(2, treeUtil.maxDepth(root));
  }

  @Test
  public void testisSymmetric() {
    TreeUtil treeUtil = new TreeUtil();
    
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    root.right = new TreeNode(7);
    assertFalse(treeUtil.isSymmetric(root));

    TreeNode root1 = new TreeNode(40);
    root1.left = new TreeNode(20);
    root1.left.left = new TreeNode(10);
    root1.left.right = new TreeNode(30);
    root1.right = new TreeNode(60);
    root1.right.left = new TreeNode(50);
    root1.right.right = new TreeNode(70);
    assertFalse(treeUtil.isSymmetric(root1));

    TreeNode root2 = new TreeNode(40);
    root1.left = new TreeNode(20);
    root1.left.left = new TreeNode(10);
    root1.left.right = new TreeNode(30);
    root1.right = new TreeNode(20);
    root1.right.left = new TreeNode(30);
    root1.right.right = new TreeNode(10);
    assertTrue(treeUtil.isSymmetric(root2));
  }
}
