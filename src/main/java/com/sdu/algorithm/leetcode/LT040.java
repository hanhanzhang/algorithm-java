package com.sdu.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LT040 {

  private static List<List<Integer>> dfs(int[] candidates, int start, int target) {
    if (target < 0) {
      return null;
    }
    List<List<Integer>> ans = new ArrayList<>();
    for (int i = start; i < candidates.length; ++i) {
      int newTarget = target - candidates[i];
      // 已排序, 剪枝
      if (newTarget < 0) {
        break;
      }
      if (i > start && candidates[i] == candidates[i - 1]) {
        // 小剪枝, candidates[i - 1]已经找过
        continue;
      }

      if (newTarget == 0) {
        List<Integer> ret = new ArrayList<>();
        ret.add(candidates[i]);
        ans.add(ret);
      } else {
        // 第i个位置不可再被选择
        List<List<Integer>> sub = dfs(candidates, i + 1, newTarget);
        if (sub == null) {
          continue;
        }
        for (List<Integer> ret : sub) {
          ret.add(candidates[i]);
          ans.add(ret);
        }
      }
    }
    return ans;
  }

  private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
    if (target <= 0) {
      return Collections.emptyList();
    }
    Arrays.sort(candidates);
    return dfs(candidates, 0, target);
  }

  public static void main(String[] args) {
    System.out.println(combinationSum2(new int[] {10, 1, 2, 7, 6, 1, 5}, 8));
    System.out.println(combinationSum2(new int[] {2, 5, 2, 1, 2}, 5));
  }

}
