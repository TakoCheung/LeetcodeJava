package com.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import com.leetcode.util.TreeNode;

public class TreeUtilTest {
  TreeUtil treeUtil = new TreeUtil();

  @Test
  public void testInorderTraversal() {
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.right = new TreeNode(3);
    assertArrayEquals(new int[] { 1, 2, 3 }, treeUtil.inorderTraversal(root).stream().mapToInt(i -> i).toArray());
  }

  @Test
  public void testPreorderTraversal() {
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.right = new TreeNode(3);
    assertArrayEquals(new int[] { 2, 1, 3 }, treeUtil.preorderTraversal(root).stream().mapToInt(i -> i).toArray());
  }

  @Test
  public void testPostorderTraversal() {
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.right = new TreeNode(3);
    assertArrayEquals(new int[] { 1, 3, 2 }, treeUtil.postorderTraversal(root).stream().mapToInt(i -> i).toArray());
  }

  @Test
  public void testValidBST() {
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
    root5.right.right.left = new TreeNode(7);
    assertTrue(treeUtil.isValidBST(root5), "Test Case 5 Failed");
  }

  @Test
  public void testInsertIntoBST() {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    root.right = new TreeNode(7);
    treeUtil.insertIntoBST(root, 5);
    assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 7 },
        treeUtil.inorderTraversal(root).stream().mapToInt(i -> i).toArray());

    TreeNode root1 = new TreeNode(40);
    root1.left = new TreeNode(20);
    root1.left.left = new TreeNode(10);
    root1.left.right = new TreeNode(30);
    root1.right = new TreeNode(60);
    root1.right.left = new TreeNode(50);
    root1.right.right = new TreeNode(70);
    treeUtil.insertIntoBST(root1, 25);
    assertArrayEquals(new int[] { 10, 20, 25, 30, 40, 50, 60, 70 },
        treeUtil.inorderTraversal(root1).stream().mapToInt(i -> i).toArray());
  }

  @Test
  public void testMaxDepth() {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    root.right = new TreeNode(7);
    assertEquals(3, treeUtil.maxDepth(root));

    TreeNode root1 = new TreeNode(40);
    root1.left = new TreeNode(20);
    root1.left.left = new TreeNode(10);
    root1.left.right = new TreeNode(30);
    root1.right = new TreeNode(60);
    root1.right.left = new TreeNode(50);
    root1.right.right = new TreeNode(70);
    root1.right.right.right = new TreeNode(80);
    assertEquals(4, treeUtil.maxDepth(root1));
  }

  @Test
  public void testIsSymmetric() {
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

  @Test
  public void testLevelOrder() {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    root.right = new TreeNode(7);
    assertEquals(new ArrayList<ArrayList<Integer>>() {
      {
        add(new ArrayList<Integer>() {
          {
            add(4);
          }
        });
        add(new ArrayList<Integer>() {
          {
            add(2);
            add(7);
          }
        });
        add(new ArrayList<Integer>() {
          {
            add(1);
            add(3);
          }
        });
      }
    }, treeUtil.levelOrder(root));
  }

  @Test
  public void testLowestCommonAncestor() {
    TreeNode root = new TreeNode(6);
    root.left = new TreeNode(2);
    root.right = new TreeNode(8);
    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(4);
    root.right.left = new TreeNode(7);
    root.right.right = new TreeNode(9);
    root.left.right.left = new TreeNode(3);
    root.left.right.right = new TreeNode(5);

    TreeNode p = root.left; // Node with value 2
    TreeNode q = root.left.right; // Node with value 4

    TreeNode lca = treeUtil.lowestCommonAncestor(root, p, q);
    assertEquals(2, lca.val);

    p = root.left; // Node with value 2
    q = root.right; // Node with value 8

    lca = treeUtil.lowestCommonAncestor(root, p, q);
    assertEquals(6, lca.val);

    p = root.left.right.left; // Node with value 3
    q = root.left.right.right; // Node with value 5

    lca = treeUtil.lowestCommonAncestor(root, p, q);
    assertEquals(4, lca.val);
  }

  @Test
  public void testDeleteNode() {
    TreeNode root = new TreeNode(6);
    root.left = new TreeNode(2);
    root.right = new TreeNode(8);
    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(4);
    root.right.left = new TreeNode(7);
    root.right.right = new TreeNode(9);
    root.left.right.left = new TreeNode(3);
    root.left.right.right = new TreeNode(5);
    treeUtil.deleteNode(root, 0);
    assertArrayEquals(new int[] { 2, 3, 4, 5, 6, 7, 8, 9 },
        treeUtil.inorderTraversal(root).stream().mapToInt(i -> i).toArray());

    treeUtil.deleteNode(root, 4);
    assertArrayEquals(new int[] { 2, 3, 5, 6, 7, 8, 9 },
        treeUtil.inorderTraversal(root).stream().mapToInt(i -> i).toArray());
  }

  @Test
  public void testIsBalanced() {
    TreeNode root = new TreeNode(6);
    root.left = new TreeNode(2);
    root.right = new TreeNode(8);
    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(4);
    root.right.left = new TreeNode(7);
    root.right.right = new TreeNode(9);
    root.left.right.left = new TreeNode(3);
    root.left.right.right = new TreeNode(5);

    assertTrue(treeUtil.isBalanced(root));
    treeUtil.maxDepth(root);
    assertTrue(treeUtil.isBalanced());

    root.left.right.right.right = new TreeNode(10);
    assertFalse(treeUtil.isBalanced(root));
    treeUtil.maxDepth(root);
    assertFalse(treeUtil.isBalanced());
  }

  // @Test
  public void testIsSameTree() {
    TreeNode p = new TreeNode(6);
    p.left = new TreeNode(2);
    p.right = new TreeNode(8);
    p.left.left = new TreeNode(0);
    p.left.right = new TreeNode(4);
    p.right.left = new TreeNode(7);
    p.right.right = new TreeNode(9);
    p.left.right.left = new TreeNode(3);
    p.left.right.right = new TreeNode(5);

    TreeNode q = new TreeNode(6);
    q.left = new TreeNode(2);
    q.right = new TreeNode(8);
    q.left.left = new TreeNode(0);
    q.left.right = new TreeNode(4);
    q.right.left = new TreeNode(7);
    q.right.right = new TreeNode(9);
    q.left.right.left = new TreeNode(3);
    q.left.right.right = new TreeNode(5);

    assertTrue(treeUtil.isSameTree(p, q));

    TreeNode p1 = new TreeNode(6);
    p.left = new TreeNode(2);
    p.right = new TreeNode(8);

    TreeNode q2 = new TreeNode(6);
    q.left = new TreeNode(8);
    q.right = new TreeNode(2);

    assertFalse(treeUtil.isSameTree(p1, q2));

  }

  // @Test
  // public void testParseJson() {
  //   String jsonData = "{\n" + //
  //       "    \"glossary\": {\n" + //
  //       "        \"title\": \"example glossary\",\n" + //
  //       "\t\t\"GlossDiv\": {\n" + //
  //       "            \"title\": \"S\",\n" + //
  //       "\t\t\t\"GlossList\": {\n" + //
  //       "                \"GlossEntry\": {\n" + //
  //       "                    \"ID\": \"SGML\",\n" + //
  //       "\t\t\t\t\t\"SortAs\": \"SGML\",\n" + //
  //       "\t\t\t\t\t\"GlossTerm\": \"Standard Generalized Markup Language\",\n" + //
  //       "\t\t\t\t\t\"Acronym\": \"SGML\",\n" + //
  //       "\t\t\t\t\t\"Abbrev\": \"ISO 8879:1986\",\n" + //
  //       "\t\t\t\t\t\"GlossDef\": {\n" + //
  //       "                        \"para\": \"A meta-markup language, used to create markup languages such as DocBook.\",\n"
  //       + //
  //       "\t\t\t\t\t\t\"GlossSeeAlso\": [\"GML\", \"XML\"]\n" + //
  //       "                    },\n" + //
  //       "\t\t\t\t\t\"GlossSee\": \"markup\"\n" + //
  //       "                }\n" + //
  //       "            }\n" + //
  //       "        }\n" + //
  //       "    }\n" + //
  //       "}";
  //   treeUtil.parseJson(jsonData);
  // }

  @Test
  public void testPreorderTraversalIterative() {
    TreeNode root = new TreeNode(6);
    root.left = new TreeNode(2);
    root.right = new TreeNode(8);
    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(4);
    root.right.left = new TreeNode(7);
    root.right.right = new TreeNode(9);
    root.left.right.left = new TreeNode(3);
    root.left.right.right = new TreeNode(5);
    List<TreeNode> preordered = treeUtil.preorderTraversalIterative(root);
    assertArrayEquals(new int[] { 6, 2, 0, 4, 3, 5, 8, 7, 9 },
        preordered.stream().mapToInt(value -> value.val).toArray());
  }

  @Test
  public void testInorderTraversalIterative() {
    TreeNode root = new TreeNode(6);
    root.left = new TreeNode(2);
    root.right = new TreeNode(8);
    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(4);
    root.right.left = new TreeNode(7);
    root.right.right = new TreeNode(9);
    root.left.right.left = new TreeNode(3);
    root.left.right.right = new TreeNode(5);
    List<TreeNode> preordered = treeUtil.inorderTraversalIterative(root);
    assertArrayEquals(new int[] { 0,2,3,4,5,6,7,8,9 },
        preordered.stream().mapToInt(value -> value.val).toArray());
  }

  @Test
  public void testPostorderTraversalIterative() {
    TreeNode root = new TreeNode(6);
    root.left = new TreeNode(2);
    root.right = new TreeNode(8);
    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(4);
    root.right.left = new TreeNode(7);
    root.right.right = new TreeNode(9);
    root.left.right.left = new TreeNode(3);
    root.left.right.right = new TreeNode(5);
    treeUtil.printTree(root);
    List<TreeNode> preordered = treeUtil.postorderTraversalIterative(root);
    assertArrayEquals(new int[] { 0,3,5,4,2,7,9,8,6 },
        preordered.stream().mapToInt(value -> value.val).toArray());
  }

  @Test
  public void testLevelOrderTravaersal() {
    TreeNode root = new TreeNode(6);
    root.left = new TreeNode(2);
    root.right = new TreeNode(8);
    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(4);
    root.right.left = new TreeNode(7);
    root.right.right = new TreeNode(9);
    root.left.right.left = new TreeNode(3);
    root.left.right.right = new TreeNode(5);
    List<List<Integer>> preordered = treeUtil.levelOrder(root);
    assertArrayEquals(new int[] { 6, 2, 8, 0, 4, 7, 9, 3, 5 },
        preordered.stream().flatMap(List::stream).mapToInt(value -> value).toArray());
  }

}
