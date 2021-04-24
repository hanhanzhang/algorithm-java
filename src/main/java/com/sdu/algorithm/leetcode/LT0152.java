package com.sdu.algorithm.leetcode;

public class LT0152 {

  private static int maxProduct(int[] nums) {
    // dp[i]: 表示以i结尾的最小值和最大值(考虑nums[i]是负数情况)
    int[][] dp = new int[nums.length][];
    dp[0] = new int[] {nums[0], nums[0]};
    int ans = dp[0][1];
    for (int i = 1; i < nums.length; ++i) {
      dp[i] = new int[2];
      if (nums[i] < 0) {  // 负数
        int min = dp[i - 1][1] * nums[i];
        int max = dp[i - 1][0] * nums[i];
        dp[i][0] = Math.min(min, nums[i]);
        dp[i][1] = Math.max(max, nums[i]);
      } else {
        int min = dp[i - 1][0] * nums[i];
        int max = dp[i - 1][1] * nums[i];
        dp[i][0] = Math.min(min, nums[i]);
        dp[i][1] = Math.max(max, nums[i]);
      }

      if (ans <= dp[i][1]) {
        ans = dp[i][1];
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(maxProduct(new int[] {2, 3, -2, 4}));
    System.out.println(maxProduct(new int[] {-2, 0, -1}));
    System.out.println(maxProduct(new int[] {-2, 2, 3, -2}));
    System.out.println(maxProduct(new int[] {-2}));
    System.out.println(maxProduct(new int[] {-2, 1}));
  }

}
