package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.Node;
import java.util.ArrayDeque;
import java.util.Queue;

public class LT559 {

  private static int maxDepth(Node root) {
    if (root == null) {
      return 0;
    }
    Queue<Node> queue = new ArrayDeque<>();
    queue.offer(root);

    int depth = 0;
    int cur = 1;
    int next = 0;
    int visit = 0;

    while (!queue.isEmpty()) {
      Node node = queue.poll();
      visit += 1;
      if (node.children != null) {
        for (Node cn : node.children) {
          next += 1;
          queue.offer(cn);
        }
      }

      if (visit == cur) {
        depth += 1;
        cur = next;
        visit = 0;
        next = 0;
      }
    }

    return depth;
  }

  public static void main(String[] args) {

  }

}
