package com.sdu.algorithm.offercode;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class JZ059 {

  private static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    if (pRoot == null) {
      return ans;
    }
    ArrayDeque<TreeNode> queue = new ArrayDeque<>();
    queue.offer(pRoot);
    boolean reverse = false;
    while (!queue.isEmpty()) {
      int len = queue.size();
      ArrayList<Integer> ret = new ArrayList<>();
      for (int i = 0; i < len; ++i) {
        TreeNode node = queue.pop();
        if (reverse) {
          ret.add(0, node.val);
        } else {
          ret.add(node.val);
        }
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }
      reverse = !reverse;
      ans.add(ret);
    }
    return ans;
  }

  public static void main(String[] args) {
    // [[8],[10,6],[5,7,9,11]]
    TreeNode root = TreeUtils.buildTree(new Integer[] {8, 6, 10, 5, 7, 9, 11});
    System.out.println(Print(root));
  }

}
