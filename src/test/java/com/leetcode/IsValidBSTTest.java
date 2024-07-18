package com.leetcode;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.leetcode.util.TreeNode;

public class IsValidBSTTest {

  @Test
  public void testValidBST() {
    IsValidBST validator = new IsValidBST();
    
    // Test Case 1: Valid BST
    TreeNode root1 = new TreeNode(2);
    root1.left = new TreeNode(1);
    root1.right = new TreeNode(3);
    assertTrue(validator.isValidBST(root1), "Test Case 1 Failed");
    
    // Test Case 2: Invalid BST (left child greater than root)
    TreeNode root2 = new TreeNode(5);
    root2.left = new TreeNode(6);
    root2.right = new TreeNode(7);
    assertFalse(validator.isValidBST(root2), "Test Case 2 Failed");
    
    // Test Case 3: Invalid BST (right child less than root)
    TreeNode root3 = new TreeNode(10);
    root3.left = new TreeNode(5);
    root3.right = new TreeNode(4);
    assertFalse(validator.isValidBST(root3), "Test Case 3 Failed");
    
    // Test Case 4: Valid BST (single node)
    TreeNode root4 = new TreeNode(1);
    assertTrue(validator.isValidBST(root4), "Test Case 4 Failed");
    
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
    assertTrue(validator.isValidBST(root5), "Test Case 5 Failed");
  }
}
