package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;

public class LT0235 {

  private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    /*
     *  -----------+--------------+-------------->
     *             p              q
     * */
    if (root == null) return null;
    if (root.val > p.val && root.val > q.val) {
      return lowestCommonAncestor(root.left, p, q);
    }
    if (root.val < p.val && root.val < q.val) {
      return lowestCommonAncestor(root.right, p, q);
    }
    // 两节点中间
    return root;
  }

  public static void main(String[] args) {
    TreeNode root = TreeUtils.buildTree(new Integer[] {6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});

    TreeNode parent = lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8));
    System.out.println(parent.val);
  }

}
