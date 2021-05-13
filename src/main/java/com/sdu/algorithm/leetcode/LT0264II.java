package com.sdu.algorithm.leetcode;

public class LT0264II {

    private static int nthUglyNumber(int n) {
        // dp[i]: 第i个丑数
        // dp[i] = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5))
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; ++i) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(num2, Math.min(num3, num5));
            // 若相等则已出现, 需向前移动一个位置
            if (dp[i] == num2) {
                p2 += 1;
            }
            if (dp[i] == num3) {
                p3 += 1;
            }
            if (dp[i] == num5) {
                p5 += 1;
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(4));
        System.out.println(nthUglyNumber(10));
    }

}
