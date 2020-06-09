package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.TreeUtils;
import com.sdu.algorithm.utils.TreeNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class LT501 {

  private static int findTreeMode(TreeNode root, int currentVal) {
    if (root == null) return 0;

    int cnt = root.val == currentVal ? 1 : 0;
    // 左子树
    cnt += findTreeMode(root.left, currentVal);
    // 右子树
    cnt += findTreeMode(root.right, currentVal);

    return cnt;
  }

  private static int[] findMode(TreeNode root) {
    List<Integer> modes = new ArrayList<>();

    Set<Integer> visited = new HashSet<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    int maxCnt = 0;
    while (!queue.isEmpty()) {
      TreeNode cur = queue.poll();
      if (cur == null || visited.contains(cur.val)) continue;

      int cnt = findTreeMode(cur, cur.val);
      visited.add(cur.val);
      if (cnt > maxCnt) {
        maxCnt = cnt;
        modes.clear();
        modes.add(cur.val);
      } else if (cnt == maxCnt) {
        modes.add(cur.val);
      }

      queue.offer(cur.left);
      queue.offer(cur.right);
    }

    int[] res = new int[modes.size()];
    for (int i = 0; i < res.length; ++i) {
      res[i] = modes.get(i);
    }
    return res;
  }

  public static void main(String[] args) {
    TreeNode root = TreeUtils.buildTree(new Integer[] {6, 2, 8, 0, 4, 7, 9, null, null, 2, 6});
    int[] result = findMode(root);
    for (int r : result) {
      System.out.println(r);
    }
  }

}
