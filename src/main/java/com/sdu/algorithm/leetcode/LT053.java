package com.sdu.algorithm.leetcode;


/**
 * 给定一个整数数组 nums, 找到一个具有最大和的连续子数组(子数组最少包含一个元素), 返回其最大和
 *
 * 示例:
 *
 * 输入: [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 * 输出: 6
 * 解释: 连续子数组 [4, -1, 2, 1] 的和最大为 6
 *
 * */
public class LT053 {

  private static int maxSubArray(int[] nums) {
    // f[i]表是以i结尾的最大连续子数组和值
    // f[i] = Math.max(f[i - 1] + a[i], a[i])

    int[] f = new int[nums.length];
    f[0] = nums[0];

    int max = f[0];
    for (int i = 1; i < nums.length; ++i) {
      if (nums[i] + f[i - 1] > nums[i]) {
        f[i] = nums[i] + f[i - 1];
      } else {
        f[i] = nums[i];
      }

      if (max < f[i]) {
        max = f[i];
      }
    }

    return max;
  }

  public static void main(String[] args) {

    int[] nums = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};

    System.out.println(maxSubArray(nums));
  }

}
