package com.leetcode;

import com.leetcode.util.Node;
import java.util.ArrayList;
import java.util.List;

public class Graph {
  public List<Integer> postorder(Node root) {
    List<Integer> ret = new ArrayList<Integer>();
    return postorderHelper(root, ret);
  }

  private List<Integer> postorderHelper(Node root, List<Integer> ret) {
    if(root == null){
      return ret;
    }
    if (!root.children.isEmpty()) {
      root.children.forEach(node -> postorderHelper(node, ret));
      ret.add(root.val);
    }
    return ret;
  }
}
