package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LT144 {

  private static List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> res = new LinkedList<>();
    Stack<TreeNode> stack = new Stack<>();

    TreeNode cur = root;
    while (cur != null || !stack.isEmpty()) {
      while (cur != null) {
        res.add(cur.val);
        stack.push(cur.right);
        cur = cur.left;
      }
      cur = stack.pop();
    }

    return res;
  }

  public static void main(String[] args) {
    TreeNode root = TreeUtils.buildTree(new Integer[] {1, 2, 3, 4, 5});
    System.out.println(preorderTraversal(root));
  }

}
