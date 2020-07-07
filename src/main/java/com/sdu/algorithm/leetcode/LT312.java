package com.sdu.algorithm.leetcode;

public class LT0312 {

  private static int maxCoins(int[] nums, int left, int right) {
    if (left > right) {
      return 0;
    }
    if (left == right) {
      return nums[left];
    }
    int ans = Integer.MIN_VALUE;
    for (int i = left + 1; i < right; ++i) {
      int value = maxCoins(nums, left, i) + maxCoins(nums, i, right)
          + nums[i - 1] * nums[i] * nums[i + 1];
      ans = Math.max(ans, value);
    }
    return ans;
  }

  private static int maxCoins(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int[] array = new int[nums.length + 2];
    for (int i = 0; i < nums.length; ++i) {
      array[i + 1] = nums[i];
    }
    array[0] = array[array.length - 1] = 1;
    return maxCoins(array, 0, array.length);
  }

  public static void main(String[] args) {
    System.out.println(maxCoins(new int[] {3, 1, 5, 8}));
  }

}
