package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树, 返回它的中序遍历(非递归模式)
 * */
public class LT094 {

  private static List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new LinkedList<>();
    Stack<TreeNode> stack = new Stack<>();

    TreeNode cur = root;

    while (cur != null || !stack.isEmpty()) {
      while (cur != null) {
        stack.push(cur);
        cur = cur.left;
      }
      cur = stack.pop();
      res.add(cur.val);
      cur = cur.right;
    }

    return res;
  }

  public static void main(String[] args) {
    TreeNode root = TreeUtils.buildTree(new Integer[] {1, null, 2, 3});
    List<Integer> result = inorderTraversal(root);
    System.out.println(result);
  }

}
