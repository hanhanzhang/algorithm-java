package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.TreeUtils;
import com.sdu.algorithm.utils.TreeNode;

public class LT450 {

  private static TreeNode adjustTree(TreeNode left, TreeNode right) {
    // 已左子树为根节点, 右子树的所有值都比左子树的值大, 故遍历右子树
    if (left == null) {
      return right;
    }
    if (left.right == null) {
      left.right = right;
      return left;
    }
    adjustTree(left.right, right);
    return left;
  }

  private static TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) return null;
    if (root.val == key) {
      return adjustTree(root.left, root.right);
    }
    if (root.val > key) {
      root.left = deleteNode(root.left, key);
      return root;
    }
    root.right = deleteNode(root.right, key);
    return root;
  }

  public static void main(String[] args) {
    TreeNode root = TreeUtils.buildTree(new Integer[] {5, 3, 6, 2, 4, null, 7});
    TreeNode newRoot = deleteNode(root, 3);
    System.out.println(newRoot.val);

    TreeNode root2 = TreeUtils.buildTree(new Integer[] {3, 1, 4, null, 2});
    TreeNode newRoot2 = deleteNode(root2, 3);
    System.out.println(newRoot2.val);
  }

}
