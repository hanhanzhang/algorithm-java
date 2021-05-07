package com.sdu.algorithm.leetcode;

public class LT0322_1 {

    private static int coinChange(int[] coins, int amount) {
        // dp[i]: 凑成i元最少的硬币数
        // dp[i] = Math.min(dp[i - coins[x]], dp[i - coins[y]])
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; ++i) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != -1) {
                    min = Math.min(min, dp[i - coin] + 1);
                }
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[] {1, 2, 5}, 11));
        System.out.println(coinChange(new int[] {2}, 3));
        System.out.println(coinChange(new int[] {1}, 0));
        System.out.println(coinChange(new int[] {1}, 1));
    }

}
