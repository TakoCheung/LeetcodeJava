package com.leetcode;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.leetcode.util.TreeNode;

public class TreeUtilTest {

  @Test
  public void testInorderTraversal() {
    TreeUtil treeUtil = new TreeUtil();
    
    TreeNode root1 = new TreeNode(2);
    root1.left = new TreeNode(1);
    root1.right = new TreeNode(3);
    assertArrayEquals(new int []{1,2,3}, treeUtil.inorderTraversal(root1).stream().mapToInt(i -> i).toArray());
  }
}
