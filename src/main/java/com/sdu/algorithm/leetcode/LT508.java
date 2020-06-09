package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.TreeUtils;
import com.sdu.algorithm.utils.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LT508 {

  private static int findFrequentTreeSum(TreeNode root, Map<Integer, Integer> res) {
    if (root == null) return 0;
    int cur = findFrequentTreeSum(root.left, res) + findFrequentTreeSum(root.right, res) + root.val;
    Integer cnt = res.getOrDefault(cur, 0);
    res.put(cur, cnt + 1);
    return cur;
  }

  private static int[] findFrequentTreeSum(TreeNode root) {
    Map<Integer, Integer> res = new HashMap<>();
    findFrequentTreeSum(root, res);
    List<Integer> maxSum = new ArrayList<>();
    int max = Integer.MIN_VALUE;
    for (Map.Entry<Integer, Integer> entry : res.entrySet()) {
      int cur = entry.getValue();
      if (cur > max) {
        maxSum.clear();
        max = cur;
        maxSum.add(entry.getKey());
      } else if (cur == max) {
        maxSum.add(entry.getKey());
      }
    }
    int[] ans = new int[maxSum.size()];
    for (int i = 0; i < maxSum.size(); ++i) {
      ans[i] = maxSum.get(i);
    }
    return ans;
  }

  public static void main(String[] args) {
    TreeNode root = TreeUtils.buildTree(new Integer[] {5, 2, -5});
    int[] ans = findFrequentTreeSum(root);
    for (int sum : ans) {
      System.out.println(sum);
    }
  }

}
