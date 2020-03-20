package com.sdu.algorithm.search;

import com.sdu.algorithm.utils.TreeNode;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树, 返回其节点值的锯齿形层次遍历(即先从左往右, 再从右往左进行下一层遍历, 以此类推, 层与层之间交替进行)
 * */
public class LT103 {

  private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }

    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);

    List<List<Integer>> result = new LinkedList<>();
    boolean reverse = false;

    while (!queue.isEmpty()) {
      int size = queue.size();
      LinkedList<Integer> levelResult = new LinkedList<>();
      for (int i = 0; i < size; ++i) {
        TreeNode node = queue.poll();
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
        if (reverse) {
          levelResult.addFirst(node.val);
        } else {
          levelResult.addLast(node.val);
        }
      }
      result.add(levelResult);
      reverse = !reverse;
    }

    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);

    TreeNode node20 = new TreeNode(20);
    node20.left = new TreeNode(15);
    node20.right = new TreeNode(7);

    root.left = new TreeNode(9);
    root.right = node20;

    zigzagLevelOrder(root);
  }

}
