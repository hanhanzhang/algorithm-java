package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;

import java.util.Stack;

public class LT0230 {

  private static int kthSmallest(TreeNode root, int k) {
    Stack<TreeNode> stack = new Stack<>();
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      TreeNode cur = stack.pop();
      if (--k == 0) {
        return cur.val;
      }
      root = cur.right;
    }
    return 0;
  }

  public static void main(String[] args) {
    Integer[] nodes = new Integer[] {5,3,6,2,4,null,null,1};
    TreeNode root = TreeUtils.buildTree(nodes);
    System.out.println(kthSmallest(root, 4));
  }

}
