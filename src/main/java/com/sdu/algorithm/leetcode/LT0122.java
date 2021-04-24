package com.sdu.algorithm.leetcode;

public class LT0122 {

    private static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // dp[i][0]: 第i天手里没有股票对应的利润, 卖或不买
        // dp[i][1]: 第i天手里有股票对应的利润, 买或不买
        // dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + price[i])
        // dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - price[i])
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
    }

}
