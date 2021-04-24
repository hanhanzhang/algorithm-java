package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;

public class LT563 {

  private static int tiltSum = 0;

  private static int treeSum(TreeNode root) {
    if (root == null) return 0;
    int ls = treeSum(root.left);
    int rs = treeSum(root.right);
    tiltSum += Math.abs(ls - rs);
    return ls + rs + root.val;
  }

  private static int findTilt(TreeNode root) {
    treeSum(root);
    return tiltSum;
  }

  public static void main(String[] args) {
    TreeNode root = TreeUtils.buildTree(new Integer[] {1, 2, 3});
    System.out.println(findTilt(root));
  }

}
