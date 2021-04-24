package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.ListUtils;
import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LT0103 {

  private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    if (root == null) {
      return ans;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    boolean isOrderLeft = true;

    while (!queue.isEmpty()) {
      int cnt = queue.size();
      // 双端队列
      LinkedList<Integer> ret = new LinkedList<>();
      for (int i = 0; i < cnt; ++i) {
        TreeNode cur = queue.poll();
        if (isOrderLeft) {
          ret.offerLast(cur.val);
        } else {
          ret.offerFirst(cur.val);
        }

        if (cur.left != null) queue.offer(cur.left);
        if (cur.right != null) queue.offer(cur.right);
      }
      isOrderLeft = !isOrderLeft;
      ans.add(ret);
    }
    return ans;
  }

  public static void main(String[] args) {
    TreeNode root = TreeUtils.buildTree(new Integer[] {3, 9, 20, null, null, 15, 7});
    List<List<Integer>> ret = zigzagLevelOrder(root);
    ListUtils.printList(ret);
  }

}
