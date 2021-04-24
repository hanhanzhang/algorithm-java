package com.sdu.algorithm.offercode;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class JZ061 {

  private static String Serialize(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    StringBuilder sb = new StringBuilder();
    boolean first = true;
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      String value = node == null ? "NULL" : String.valueOf(node.val);
      if (first) {
        sb.append(value);
        first = false;
      } else {
        sb.append("#");
        sb.append(value);
      }

      if (node != null) {
        queue.offer(node.left);
        queue.offer(node.right);
      }
    }

    return sb.toString();
  }

  private static TreeNode Deserialize(String str) {
    String[] values = str.split("#");
    if (values[0].equals("NULL")) {
      return null;
    }
    TreeNode root = new TreeNode(Integer.parseInt(values[0]));
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    int cur = 1;
    while (cur < values.length) {
      TreeNode node = queue.poll();
      TreeNode left = values[cur].equals("NULL") ? null : new TreeNode(Integer.parseInt(values[cur]));
      cur += 1;
      TreeNode right = values[cur].equals("NULL") ? null : new TreeNode(Integer.parseInt(values[cur]));
      cur += 1;
      node.left = left;
      node.right = right;
      if (left != null) {
        queue.offer(left);
      }
      if (right != null) {
        queue.offer(right);
      }
    }
    return root;
  }

  public static void main(String[] args) {
    TreeNode root = TreeUtils.buildTree(new Integer[] {1, 2, 3, null, null, 4, 5});
    String data = Serialize(root);
    System.out.println(data);

    TreeNode newRoot = Deserialize(data);
    if (newRoot != null) {
      System.out.println(newRoot.val);
    }

  }

}
