package com.sdu.algorithm.leetcode;

public class LT0494 {

  private static int findTargetSumWays(int[] nums, int target) {
    // dp[i]: 表示以i结尾的所有元素和
    int[][] dp = new int[nums.length][];
    dp[0] = new int[] {nums[0], -nums[0]};
    for (int i = 1; i < nums.length; ++i) {
      dp[i] = new int[dp[i - 1].length * 2];
      int index = 0;
      for (int subSum : dp[i - 1]) {
        dp[i][index++] = subSum + nums[i];
        dp[i][index++] = subSum - nums[i];
      }
    }
    int[] sums = dp[nums.length - 1];
    int cnt = 0;
    for (int sum : sums) {
      if (sum == target) cnt += 1;
    }
    return cnt;
  }

  public static void main(String[] args) {
    System.out.println(findTargetSumWays(new int[] {1, 1, 1, 1, 1}, 3));
    System.out.println(findTargetSumWays(new int[] {1}, 1));
    System.out.println(findTargetSumWays(new int[] {1, 0}, 1));
  }

}
