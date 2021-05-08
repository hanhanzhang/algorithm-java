package com.sdu.algorithm.leetcode;

public class LT0198 {

    private static int rob(int[] nums) {
        // dp[i]: (0, i)间获取的最大金额
        // 对于nums[i]有两种选择, 偷或不偷
        // dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i])
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < nums.length; ++i) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[] {2, 7, 9, 3, 1}));
    }

}
