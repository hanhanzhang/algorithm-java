package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;

public class LT0236 {

  private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) return null;
    if (root.val == p.val || root.val == q.val ) return root;
    // 若在左子树和右子树都找到, 则最近的公共祖先为当前的根节点
    TreeNode l = lowestCommonAncestor(root.left, p, q);
    TreeNode r = lowestCommonAncestor(root.right, p, q);

    if (l != null && r != null) return root;
    if (l == null && r == null) return null;
    return l != null ? l : r;
  }

  public static void main(String[] args) {
    TreeNode root = TreeUtils.buildTree(new Integer[] {3, 5, 1, 6, 2, 0, 8, 7, 4});
    System.out.println(lowestCommonAncestor(root, new TreeNode(5), new TreeNode(1)));
  }

}
