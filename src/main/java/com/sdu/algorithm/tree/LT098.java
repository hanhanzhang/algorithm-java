package com.sdu.algorithm.tree;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LT098 {

  private static void visitBST(TreeNode root, List<Integer> nodes) {
    if (root == null) {
      return;
    }
    visitBST(root.left, nodes);
    nodes.add(root.val);
    visitBST(root.right, nodes);
  }

  /*
   * 二叉搜索树特点: 左序遍历树是有序队列
   * */
  private static boolean isValidBST(TreeNode root) {
    List<Integer> nodes = new LinkedList<>();
    visitBST(root, nodes);

    Iterator<Integer> it = nodes.iterator();
    Integer v = null;
    while (it.hasNext()) {
      int n = it.next();
      if (v == null) {
        v = n;
        continue;
      }
      if (n < v) {
        return false;
      }
      v = n;
    }
    return true;
  }

  private static boolean isValidBST(TreeNode node, long min, long max) {
    if (node == null) {
      return true;
    }
    if (node.val <= min || node.val >= max) {
      return false;
    }
    return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
  }

  /*
   * 二叉搜索树特点: 左边树节点值都是要小于根节点的, 右边树节点值都是要大于根节点的
   * */
  private static boolean isValidBST0(TreeNode root) {
    return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  public static void main(String[] args) {
    TreeNode root = TreeUtils.buildTree(new Integer[] {5, 1, 4, null, null, 3, 6});
    System.out.println(isValidBST0(root));
  }

}
