package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.TreeUtils;
import com.sdu.algorithm.utils.TreeNode;

public class LT530 {

  private static int pre;
  private static int minDif;

  private static int getMinimumDifference(TreeNode root) {
    pre = -1;
    minDif = Integer.MAX_VALUE;
    inOrder(root);
    return minDif;
  }

  private static void inOrder(TreeNode root) {
    if(root == null)    return;
    inOrder(root.left);
    if(pre != -1)
      minDif = Math.min(minDif, root.val - pre);
    pre = root.val;
    inOrder(root.right);
  }


  public static void main(String[] args) {
    TreeNode root = TreeUtils.buildTree(new Integer[] {1, null, 3, 2});
    System.out.println(getMinimumDifference(root));

    TreeNode root2 = TreeUtils.buildTree(new Integer[] {543, 384, 652, null, 445, null, 699});
    System.out.println(getMinimumDifference(root2));

    TreeNode root3 = TreeUtils.buildTree(new Integer[] {0, null, 2236, 1277, 2776, 519});
    System.out.println(getMinimumDifference(root3));

    TreeNode root4 = TreeUtils.buildTree(new Integer[] {5, 4, 7});
    System.out.println(getMinimumDifference(root4));
  }

}
