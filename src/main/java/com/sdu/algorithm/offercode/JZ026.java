package com.sdu.algorithm.offercode;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;

public class JZ026 {

  private static TreeNode root = null;
  private static TreeNode pre = null;

  private static TreeNode Convert(TreeNode pRootOfTree) {
    if (pRootOfTree == null) {
      return null;
    }
    Convert(pRootOfTree.left);
    if (root == null) {
      root = pRootOfTree;
    }
    if (pre != null) {
      pRootOfTree.left = pre;
      pre.right = pRootOfTree;
    }
    pre = pRootOfTree;
    Convert(pRootOfTree.right);
    return root;
  }

  public static void main(String[] args) {
    TreeNode root = TreeUtils.buildTree(new Integer[] {10, 8, 14, 6, 9, 12, 15});

    TreeNode head = Convert(root);
    while (head != null) {
      System.out.println(head.val);
      head = head.right;
    }
  }

}
