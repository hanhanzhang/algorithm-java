package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.TreeNode;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LT515 {

  private static List<Integer> largestValues(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    List<Integer> result = new LinkedList<>();
    while (!queue.isEmpty()) {
      int size = queue.size();
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < size; ++i) {
        TreeNode n = queue.poll();
        if (n.val > max) {
          max = n.val;
        }
        if (n.left != null) {
          queue.offer(n.left);
        }
        if (n.right != null) {
          queue.offer(n.right);
        }
      }
      result.add(max);
    }

    return result;
  }

  public static void main(String[] args) {

  }

}
