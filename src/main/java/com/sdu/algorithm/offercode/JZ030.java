package com.sdu.algorithm.offercode;

public class JZ030 {

  private static int FindGreatestSumOfSubArray(int[] array) {
    // 最值问题: 有限考虑动态规划
    int max = Integer.MIN_VALUE;
    int[] dp = new int[array.length];
    dp[0] = array[0];
    for (int i = 1; i < array.length; ++i) {
      dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
      if (dp[i] > max) {
        max = dp[i];
      }
    }
    return max;
  }

  public static void main(String[] args) {
    System.out.println(FindGreatestSumOfSubArray(new int[] {6, -3, -2, 7, -15, 1, 2, 2}));
  }

}
