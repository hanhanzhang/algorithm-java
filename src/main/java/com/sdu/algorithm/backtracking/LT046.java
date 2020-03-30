package com.sdu.algorithm.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LT046 {

  private static List<List<Integer>> backtrack(int[] nums, Set<Integer> visited) {
    if (nums.length == visited.size()) return new ArrayList<>();

    List<List<Integer>> result = new LinkedList<>();

    for (int i = 0; i < nums.length; ++i) {
      if (visited.contains(nums[i])) {
        continue;
      }
      visited.add(nums[i]);

      List<List<Integer>> subPermutes = backtrack(nums, visited);
      if (subPermutes.isEmpty()) {
        List<Integer> permute = new ArrayList<>();
        permute.add(nums[i]);
        result.add(permute);
        // 回溯之前的状态
        visited.remove(nums[i]);
        continue;
      }
      for (List<Integer> permute : subPermutes) {
        permute.add(0, nums[i]);
        result.add(permute);
        // 回溯之前的状态
        visited.remove(nums[i]);
      }

    }

    return result;
  }

  private static List<List<Integer>> permute(int[] nums) {
    return backtrack(nums, new HashSet<>());
  }

  public static void main(String[] args) {
    List<List<Integer>> permutes = permute(new int[] {1, 2, 3});
    for (List<Integer> permute : permutes) {
      System.out.println(permute);
    }
  }

}
