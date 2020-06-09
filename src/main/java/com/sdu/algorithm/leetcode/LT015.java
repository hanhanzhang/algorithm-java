package com.sdu.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LT015 {

  private static List<List<Integer>> dfs(int[]nums, int start, int target, int dept) {
    if (start >= nums.length || dept <= 0) {
      return Collections.emptyList();
    }

    if (dept == 1) {
      List<Integer> ans = new LinkedList<>();
      Set<Integer> visited = new HashSet<>();
      for (int i = start; i < nums.length; ++i) {
        if (nums[i] == target && visited.add(nums[i])) {
          ans.add(nums[i]);
        }
      }
      if (ans.isEmpty()) {
        return Collections.emptyList();
      }
      return Collections.singletonList(ans);
    }

    List<List<Integer>> ans = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();
    for (int i = start; i < nums.length; ++i) {
      if (!visited.add(nums[i])) {
        continue;
      }
      List<List<Integer>> res = dfs(nums, i + 1, target - nums[i], dept - 1);
      if (res.isEmpty()) {
        continue;
      }
      for (List<Integer> sub : res) {
        sub.add(nums[i]);
        ans.add(sub);
      }
    }
    return ans;
  }

  private static List<List<Integer>> threeSum(int[] nums) {
    if (nums == null || nums.length == 0) return Collections.emptyList();
    Arrays.sort(nums);
    Map<Integer, Integer> numToCnt = new HashMap<>();
    for (int num : nums) {
      int cnt = numToCnt.getOrDefault(num, 0);
      numToCnt.put(num, cnt + 1);
    }
    return dfs(nums, 0, 0, 3);
  }

  public static void main(String[] args) {
    List<List<Integer>> ans = threeSum(new int[] {-1, 0, 1, 2, -1, -4});
    System.out.println(ans);

    List<List<Integer>> ans1 = threeSum(new int[] {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6});
    System.out.println(ans1);
  }

}
