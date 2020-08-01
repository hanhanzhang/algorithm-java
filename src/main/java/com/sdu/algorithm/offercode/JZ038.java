package com.sdu.algorithm.offercode;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;

public class JZ038 {

  private static int TreeDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    return 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
  }

  public static void main(String[] args) {
    TreeNode root = TreeUtils.buildTree(new Integer[] {1, 2, null, 3, 4, 5});
    System.out.println(TreeDepth(root));
  }

}
