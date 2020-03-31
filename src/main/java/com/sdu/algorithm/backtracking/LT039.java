package com.sdu.algorithm.backtracking;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LT039 {

  private static List<List<Integer>> combinationSum(int[] candidates, int target) {
    // TODO: 如何去重(做减法, 转为多叉树)
    if (target < 0) return Collections.emptyList();

    List<List<Integer>> result = new LinkedList<>();

    for (int i = 0; i < candidates.length; ++i) {
      int newTarget = target - candidates[i];
      if (newTarget == 0)  {
        List<Integer> sub = new LinkedList<>();
        sub.add(candidates[i]);
        result.add(sub);
      } else {
        List<List<Integer>> subResult = combinationSum(candidates, newTarget);
        if (subResult.isEmpty()) {
          continue;
        }
        for (List<Integer> sub : subResult) {
          sub.add(candidates[i]);
          result.add(sub);
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    List<List<Integer>> result = combinationSum(new int[] {7, 3, 6, 2}, 7);
    for (List<Integer> r : result) {
      System.out.println(r);
    }
  }

}
