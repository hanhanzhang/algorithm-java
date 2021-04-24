package com.sdu.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LT0047 {

    private static List<List<Integer>> backtrack(int[] nums, boolean[] visited) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (visited[i]) {
                continue;
            }
            // 剪枝条件: nums[i] == nums[i - 1] & visited[i - 1] == false
            // 关键点: 相同元素已选择
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
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
            visited[i] = false;
        }
        return ans;
    }

    private static List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        return backtrack(nums, new boolean[nums.length]);
    }

    public static void main(String[] args) {
        List<List<Integer>> permutes = permuteUnique(new int[] {1, 1, 2});
        for (List<Integer> permute : permutes) {
            System.out.println(permute);
        }
    }

}
