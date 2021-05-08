package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LT0144 {

  private static List<Integer> preorderTraversal(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    List<Integer> res = new ArrayList<>();
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        res.add(root.val);
        if (root.right != null) stack.push(root.right);
        root = root.left;
      }
      if (!stack.isEmpty()) {
        root = stack.pop();
      }
    }
    return res;
  }

  public static void main(String[] args) {
    TreeNode root = TreeUtils.buildTree(new Integer[] {1, 2, 3, 4, 5});
    System.out.println(preorderTraversal(root));
  }

}
