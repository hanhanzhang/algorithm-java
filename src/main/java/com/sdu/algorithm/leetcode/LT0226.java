package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;

public class LT0226 {

  private static TreeNode invertTree(TreeNode root) {
    if (root == null) return null;
    TreeNode ops = root.left;
    root.left = root.right;
    root.right = ops;
    invertTree(root.left);
    invertTree(root.right);
    return root;
  }

  public static void main(String[] args) {
    TreeNode root1 = TreeUtils.buildTree(new Integer[] {4, 2, 7, 1, 3, 6, 9});
    invertTree(root1);

    TreeNode root2 = TreeUtils.buildTree(new Integer[] {1, 2});
    invertTree(root2);

  }

}
