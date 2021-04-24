package com.sdu.algorithm.leetcode;

public class LT0300 {

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // dp[i]: 以i为起点的最长递增子序列长度
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 1;
        int res = dp[nums.length - 1];
        for (int i = nums.length - 2; i >=0; --i) {
            int num = nums[i];
            int maxLen = 1;
            for (int k = i + 1; k < nums.length; ++k) {
                if (num < nums[k] && maxLen < dp[k] + 1) {
                    maxLen = dp[k] + 1;
                }
            }
            dp[i] = maxLen;
            if (res < dp[i]) {
                res = dp[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[] {10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(lengthOfLIS(new int[] {0, 1, 0, 3, 2, 3}));
        System.out.println(lengthOfLIS(new int[] {7, 7, 7, 7, 7, 7, 7}));
        System.out.println(lengthOfLIS(new int[] {0}));
    }

}
