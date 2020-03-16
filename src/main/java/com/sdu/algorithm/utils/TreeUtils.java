package com.sdu.algorithm.utils;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtils {

  private TreeUtils() {

  }


  public static TreeNode buildTree(Integer[] nodes) {
    if (nodes == null || nodes.length == 0) {
      return null;
    }

    TreeNode root = new TreeNode(nodes[0]);

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    int pos = 1;

    while (!queue.isEmpty()) {
      // 构建当前节点左右节点
      TreeNode node = queue.poll();

      // 左节点
      if (pos >= nodes.length) {
        break;
      }
      if (nodes[pos] != null) {   // 存在
        node.left = new TreeNode(nodes[pos++]);
        queue.offer(node.left);
      } else {
        pos++;
      }

      // 右节点
      if (pos >= nodes.length) {
        break;
      }
      if (nodes[pos] != null) {
        node.right = new TreeNode(nodes[pos++]);
        queue.offer(node.right);
      } else {
        pos++;
      }
    }

    return root;
  }

  public static void main(String[] args) {
    Integer[] nodes = new Integer[] {5,4,8,11,null,13,4,7,2,null,null,5,1};

    TreeNode root = buildTree(nodes);
    System.out.println(root.val);
  }

}
