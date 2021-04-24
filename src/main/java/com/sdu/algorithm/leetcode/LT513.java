package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class LT513 {

  private static int findBottomLeftValue(TreeNode root) {
    if (root == null) {
      return 0;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int value = root.val;

    while (!queue.isEmpty()) {
      int size = queue.size();
      // 遍历完本层
      for (int i = 0; i < size; ++i) {
        TreeNode cur = queue.poll();
        if (i == 0) {
          value = cur.val;
        }
        if (cur.left != null) {
          queue.offer(cur.left);
        }
        if (cur.right != null) {
          queue.offer(cur.right);
        }
      }
    }

    return value;
  }

  public static void main(String[] args) {

  }

}
