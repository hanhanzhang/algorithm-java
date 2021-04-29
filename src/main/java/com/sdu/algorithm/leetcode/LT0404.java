package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;

public class LT0404 {

  private static int sumOfLeftLeavesInternal(TreeNode root, boolean isLeft) {
    if (root == null) return 0;
    if (root.left == null && root.right == null) {
      return isLeft ? root.val : 0;
    }
    return sumOfLeftLeavesInternal(root.left, true)
         + sumOfLeftLeavesInternal(root.right, false);
  }

  private static int sumOfLeftLeaves(TreeNode root) {
    return sumOfLeftLeavesInternal(root, false);
  }

  public static void main(String[] args) {
    TreeNode root = TreeUtils.buildTree(new Integer[] {3, 9, 20, null, null, 15, 7});
    System.out.println(sumOfLeftLeaves(root));
  }

}
