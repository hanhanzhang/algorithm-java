package com.sdu.algorithm.tree;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;

public class LT230 {

  private static int kth = 0;
  private static int kthVal = 0;

  private static int kthSmallest(TreeNode root, int k) {
    if (kth > k || root == null) {
      return kthVal;
    }

    kthSmallest(root.left, k);
    if (++kth == k) {
      kthVal = root.val;
    }
    kthSmallest(root.right, k);

    return kthVal;
  }

  public static void main(String[] args) {
    Integer[] nodes = new Integer[] {5,3,6,2,4,null,null,1};
    TreeNode root = TreeUtils.buildTree(nodes);
    kthSmallest(root, 3);

    System.out.println(kthSmallest(root, 3));
  }

}
