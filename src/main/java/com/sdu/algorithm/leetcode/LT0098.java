package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;

public class LT0098 {

  private static boolean isValidBST(TreeNode root, Integer min, Integer max) {
    if (root == null) {
      return true;
    }
    if ((max != null && root.val >= max) || (min != null && root.val <= min)) {
      return false;
    }
    return isValidBST(root.left, min, root.val)
            && isValidBST(root.right, root.val, max);
  }

  private static boolean isValidBST(TreeNode root) {
    return isValidBST(root, null, null);
  }

  public static void main(String[] args) {
    TreeNode root1 = TreeUtils.buildTree(new Integer[] {5, 1, 4, null, null, 3, 6});
    System.out.println(isValidBST(root1));

    TreeNode root2 = TreeUtils.buildTree(new Integer[] {5, 1, 7, null, null, 6, 8});
    System.out.println(isValidBST(root2));

    TreeNode root3 = TreeUtils.buildTree(new Integer[] {2, 1, 3});
    System.out.println(isValidBST(root3));

    TreeNode root4 = TreeUtils.buildTree(new Integer[] {1, 1});
    System.out.println(isValidBST(root4));

    TreeNode root5 = TreeUtils.buildTree(new Integer[] {Integer.MAX_VALUE});
    System.out.println(isValidBST(root5));
  }

}
