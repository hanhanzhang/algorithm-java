package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;

public class LT0617 {

  private static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    if (t1 == null || t2 == null) {
      return t1 == null ? t2 : t1;
    }
    TreeNode node = new TreeNode(t1.val + t2.val);
    node.left = mergeTrees(t1.left, t2.left);
    node.right = mergeTrees(t1.right, t2.right);
    return node;
  }

  public static void main(String[] args) {
    TreeNode t1 = TreeUtils.buildTree(new Integer[] {1, 3, 2, 5});
    TreeNode t2 = TreeUtils.buildTree(new Integer[] {2, 1, 3, null, 4, null, 7});

    TreeNode root = mergeTrees(t1, t2);
    System.out.println(root.val);
  }

}
