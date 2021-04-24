package com.sdu.algorithm.leetcode;

public class LT0044_1 {

    private static boolean isMatch(String s, String p) {
        // dp[i][j]
        // 若s[i] == p[j], 则dp[i][j] = dp[i - 1][j - 1]
        // 若p[j] == '?',  则dp[i][j] = dp[i - 1][j - 1]
        // 若p[j] == '*',  则dp[i][j] = dp[i][j - 1] || dp[i - 1][j] (匹配零次或多次)
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        // 特例: 字符串s为空串时
        for (int j = 1; j <= p.length(); ++j) {
            dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j - 1];
        }
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 1; j <= p.length(); ++j) {
                char ch1 = s.charAt(i - 1), ch2 = p.charAt(j - 1);
                if (ch1 == ch2 || ch2 == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (ch2 == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "********"));
        System.out.println(isMatch("cb", "?a"));
        System.out.println(isMatch("adceb", "*a*b"));
    }

}
