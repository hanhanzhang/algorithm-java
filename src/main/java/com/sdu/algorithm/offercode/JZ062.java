package com.sdu.algorithm.offercode;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;
import java.util.Stack;

public class JZ062 {

  private static int kthNode(TreeNode root, int kth) {
    Stack<TreeNode> stack = new Stack<>();
    int cnt = 0;
    while (!stack.isEmpty() || root != null) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      // visit
      TreeNode node = stack.pop();
      cnt += 1;
      if (cnt == kth) {
        return node.val;
      }
      root = node.right;
    }
    return 0;
  }

  public static void main(String[] args) {
    TreeNode root = TreeUtils.buildTree(new Integer[] {5, 3, 7, 2, 4, 6, 8});
    System.out.println(kthNode(root, 3));
  }

}
