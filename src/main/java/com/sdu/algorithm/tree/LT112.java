package com.sdu.algorithm.tree;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;

public class LT112 {

  private static boolean hasPathSums(TreeNode root, int exceptNum) {
    if (root.left == null && root.right == null) {
      return exceptNum == root.val;
    }

    boolean left = false;
    if (root.left != null) left = hasPathSums(root.left, exceptNum - root.val);

    boolean right = false;
    if (root.right != null) right = hasPathSums(root.right, exceptNum - root.val);

    return left || right;
  }

  private static boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) return false;

    return hasPathSums(root, sum);
  }

  public static void main(String[] args) {
    TreeNode root = TreeUtils.buildTree(new Integer[] {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
    System.out.println(hasPathSum(root, 22));
  }

}
