package com.sdu.algorithm.offercode;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;

public class JZ018 {

  private static void Mirror(TreeNode root) {
    if (root == null) {
      return;
    }
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
    Mirror(root.left);
    Mirror(root.right);
  }

  public static void main(String[] args) {
    TreeNode root = TreeUtils.buildTree(new Integer[] {8, 6, 10, 5, 7, 9, 11});
    Mirror(root);
    System.out.println(root.val);
  }

}
