package com.sdu.algorithm.leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LT0078 {

  private static List<List<Integer>> dfs(int[] nums, int start) {
    List<List<Integer>> ans = new LinkedList<>();
    if (start >= nums.length) {
      ans.add(new LinkedList<>());
      return ans;
    }

    List<List<Integer>> sub = dfs(nums, start + 1);
    ans.addAll(sub);
    for (List<Integer> s : sub) {
      List<Integer> ss = new LinkedList<>();
      ss.add(nums[start]);
      ss.addAll(s);
      ans.add(ss);
    }

    return ans;
  }

  private static List<List<Integer>> subsets(int[] nums) {
    if (nums == null) {
      return Collections.emptyList();
    }
    return dfs(nums, 0);
  }

  public static void main(String[] args) {
    System.out.println(subsets(new int[] {1, 2, 3}));
  }

}
