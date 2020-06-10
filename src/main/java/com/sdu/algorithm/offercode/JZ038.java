package com.sdu.algorithm.offercode;

import com.sdu.algorithm.utils.TreeNode;

public class JZ038 {

  private static int TreeDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    return 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
  }

  public static void main(String[] args) {

  }

}
