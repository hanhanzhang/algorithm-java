package com.sdu.algorithm.leetcode;

public class LT0053 {

  private static int maxSubArray(int[] nums) {
    // f[i]表是以i结尾的最大连续子数组和值
    // f[i] = Math.max(f[i - 1] + a[i], a[i])
    int pre = 0, maxAns = nums[0];
    for (int num : nums) {
      pre = Math.max(num, num + pre);
      maxAns = Math.max(pre, maxAns);
    }
    return maxAns;
  }

  public static void main(String[] args) {
    int[] nums = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println(maxSubArray(nums));
  }

}
