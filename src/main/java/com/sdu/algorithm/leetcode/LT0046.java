package com.sdu.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LT0046 {

  private static List<List<Integer>> backtrack(int[] nums, boolean[] visited) {
    if (nums == null || nums.length == 0) {
      return Collections.emptyList();
    }
    List<List<Integer>> ans = new ArrayList<>();
    for (int i = 0; i < nums.length; ++i) {
      if (visited[i]) {
        continue;
      }
      visited[i] = true;
      List<List<Integer>> subPermutes = backtrack(nums, visited);
      if (subPermutes.isEmpty()) {
        List<Integer> ret = new ArrayList<>();
        ret.add(nums[i]);
        ans.add(ret);
      } else {
        for (List<Integer> ret : subPermutes) {
          ret.add(nums[i]);
          ans.add(ret);
        }
      }
      // 回溯
      visited[i] = false;
    }
    return ans;
  }

  private static List<List<Integer>> permute(int[] nums) {
    // 回溯算法: 枚举, 若某个路径符合则加入计算结果, 否则回溯寻找另一条路径
    return backtrack(nums, new boolean[nums.length]);
  }

  public static void main(String[] args) {
    List<List<Integer>> permutes = permute(new int[] {1, 2, 3});
    for (List<Integer> permute : permutes) {
      System.out.println(permute);
    }
  }

}
