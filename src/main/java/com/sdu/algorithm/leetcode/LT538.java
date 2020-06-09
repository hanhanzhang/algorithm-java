package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.TreeNode;

public class LT538 {

  private static int sum = 0;

  private static TreeNode convertBST(TreeNode root) {
    if (root != null) {
      convertBST(root.right);
      sum += root.val;
      root.val = sum;
      convertBST(root.left);
    }
    return root;
  }

  public static void main(String[] args) {
  }

}
