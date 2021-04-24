package com.sdu.algorithm.leetcode;

import java.util.Arrays;

public class LT416 {

  private static boolean dfs(int target, int[] nums, int start) {
    if (start < 0 || target < 0) {
      return false;
    }
    if (target == 0) {
      return true;
    }
    for (int i = start; i >= 0; --i) {
      if (nums[i] > target) {
        return false;
      }
      boolean exist = dfs(target - nums[i], nums, i - 1);
      if (exist) {
        return true;
      }
    }
    return false;
  }

  private static boolean canPartition(int[] nums) {
    int sum = Arrays.stream(nums).sum();
    int remainder = sum % 2;
    if (remainder != 0) {
      return false;
    }
    int target = sum / 2;
    Arrays.sort(nums);
    return dfs(target, nums, nums.length - 1);
  }

  public static void main(String[] args) {
    System.out.println(canPartition(new int[]{1, 5, 11, 5}));
    System.out.println(canPartition(new int[]{1, 2, 3, 5}));
    System.out.println(canPartition(new int[]{1, 2, 5}));
    System.out.println(canPartition(new int[]{3, 3, 3, 4, 5}));
    System.out.println(canPartition(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,100}));
  }

}
