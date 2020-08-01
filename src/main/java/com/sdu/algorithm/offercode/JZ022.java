package com.sdu.algorithm.offercode;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class JZ022 {

  private static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
    ArrayList<Integer> ans = new ArrayList<>();

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (node == null) {
        continue;
      }
      ans.add(node.val);
      queue.offer(node.left);
      queue.offer(node.right);
    }

    return ans;
  }

  public static void main(String[] args) {
    TreeNode root = TreeUtils.buildTree(new Integer[] {1, 2, 3, 4, 5, 6, 7});
    System.out.println(PrintFromTopToBottom(root));
  }

}
