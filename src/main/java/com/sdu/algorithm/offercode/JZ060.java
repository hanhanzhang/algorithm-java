package com.sdu.algorithm.offercode;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class JZ060 {

  private static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(pRoot);

    while (!queue.isEmpty()) {
      int len = queue.size();
      ArrayList<Integer> ret = new ArrayList<>();
      for (int i = 0; i < len; ++i) {
        TreeNode node = queue.poll();
        if (node == null) {
          continue;
        }
        ret.add(node.val);
        queue.offer(node.left);
        queue.offer(node.right);
      }
      if (!ret.isEmpty()) {
        ans.add(ret);
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    TreeNode root = TreeUtils.buildTree(new Integer[] {1, 2, 3, 4, 5, 6, 7});
    System.out.println(Print(root));
  }

}
