package com.sdu.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LT491 {

  private static List<List<Integer>> findSubsequences(int[] nums) {
    // dp[i] 表示以num[i]结尾的所有递增子序列, 注意: dp[i]长度可为1
    List<List<Integer>> dp = new ArrayList<>();
    Set<List<Integer>> visited = new HashSet<>();
    List<List<Integer>> ans = new LinkedList<>();
    for (int i = 0; i < nums.length; ++i) {
      if (i == 0) {
        List<Integer> subList = Collections.singletonList(nums[i]);
        dp.add(subList);
        visited.add(subList);
        continue;
      }
      int len = dp.size();
      for (int m = len - 1; m >= 0; --m) {
        List<Integer> subList = dp.get(m);
        int max = subList.get(subList.size() - 1);
        if (max <= nums[i]) {
          List<Integer> newSubList = new ArrayList<>(subList);
          newSubList.add(nums[i]);
          if (visited.contains(newSubList)) {
            continue;
          }
          dp.add(newSubList);
          ans.add(newSubList);
          visited.add(newSubList);
        }
      }
      List<Integer> self = Collections.singletonList(nums[i]);
      if (visited.contains(self)) {
        continue;
      }
      dp.add(self);
      visited.add(self);
    }
    return ans;

  }

  public static void main(String[] args) {
    List<List<Integer>> ans = findSubsequences(new int[] {4, 6, 7, 7});
    System.out.println(ans);

    List<List<Integer>> ans2 = findSubsequences(new int[] {1, 1, 1, 1, 1});
    System.out.println(ans2);
  }

}
