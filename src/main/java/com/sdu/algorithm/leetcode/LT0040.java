package com.sdu.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LT0040 {

  private static void find(int[] candidates, int target, int start, List<Integer> mid, List<List<Integer>> result) {
    if (target == 0) {
      result.add(mid);
      return;
    }
    if (target < 0 ) {
      return;
    }
    boolean first = true;
    for (int i = start; i < candidates.length; ++i) {
      if (first || candidates[i - 1] != candidates[i]) {  // 去重
        List<Integer> newMid = new LinkedList<>(mid);
        newMid.add(candidates[i]);
        find(candidates, target - candidates[i], i + 1, newMid, result);
      }
      first = false;
    }
  }

  private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(candidates);
    find(candidates, target, 0, new ArrayList<>(), res);
    return res;
  }

  public static void main(String[] args) {
    System.out.println(combinationSum2(new int[] {10, 1, 2, 7, 6, 1, 5}, 8));
    System.out.println(combinationSum2(new int[] {2, 5, 2, 1, 2}, 5));
  }

}
