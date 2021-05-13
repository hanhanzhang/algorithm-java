package com.sdu.algorithm.leetcode;

public class LT0516M {

    private static int longestPalindromeSubseq(String s) {
        // 区间动态规划
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int len = 2; len <= n; ++len) {
            for (int l = 0; l + len - 1 < n; ++l) {
                int r = l + len - 1;
                if (s.charAt(l) == s.charAt(r)) {
                    dp[l][r] = dp[l + 1] [r - 1] + 2;
                } else {
                    dp[l][r] = Math.max(dp[l + 1][r], dp[l][r - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("bbbab"));
        System.out.println(longestPalindromeSubseq("cbbd"));
    }

}
