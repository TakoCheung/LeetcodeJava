import java.util.Stack;

import util.TreeNode;

public class IsValidBST {

  public boolean isValidBST(TreeNode root) {
    if (root == null)
      return true;
    Stack<TreeNode> stack = new Stack<>();
    TreeNode pre = null;
    while (root != null || !stack.isEmpty()) {
      System.out.println("out while");
      while (root != null) {
        stack.push(root);
        root = root.left;
        System.out.println("in while");
      }
      System.out.println(stack);
      root = stack.pop();
      if (pre != null && root.val <= pre.val)
        return false;
      pre = root;
      root = root.right;
    }
    return true;
  }
}