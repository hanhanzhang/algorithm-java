package com.sdu.algorithm.tree;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;

public class LT617 {

  private static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) return null;
    if (t1 != null && t2 != null) {
      TreeNode node = new TreeNode(t1.val + t2.val);
      node.left = mergeTrees(t1.left, t2.left);
      node.right = mergeTrees(t1.right, t2.right);
      return node;
    }

    TreeNode nonEmptyNode = t1 != null ? t1 : t2;
    TreeNode node = new TreeNode(nonEmptyNode.val);
    node.left = nonEmptyNode.left;
    node.right = nonEmptyNode.right;
    return node;
  }

  public static void main(String[] args) {
    TreeNode t1 = TreeUtils.buildTree(new Integer[] {1, 3, 2, 5});
    TreeNode t2 = TreeUtils.buildTree(new Integer[] {2, 1, 3, null, 4, null, 7});

    TreeNode root = mergeTrees(t1, t2);
    System.out.println(root.val);
  }

}
