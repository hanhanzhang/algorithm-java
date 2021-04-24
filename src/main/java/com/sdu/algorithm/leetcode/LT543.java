package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;
import java.util.LinkedList;
import java.util.Queue;

public class LT543 {

  private static int treeHeight(TreeNode root) {
    if (root == null) return 0;
    int left = treeHeight(root.left) + 1;
    int right = treeHeight(root.right) + 1;
    return Math.max(left, right);
  }

  private static int diameterOfBinaryTree(TreeNode root) {
    if (root == null) return 0;

    int max = -1;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (node == null) {
        continue;
      }
      queue.offer(node.left);
      queue.offer(node.right);
      int len = treeHeight(node.left) + treeHeight(node.right) + 1;

      if (len > max) max = len;

    }
    return max - 1;
  }

  public static void main(String[] args) {
    TreeNode root = TreeUtils.buildTree(new Integer[] {1, 2, 3, 4, 5});
    System.out.println(diameterOfBinaryTree(root));
  }

}
