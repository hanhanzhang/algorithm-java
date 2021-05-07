package com.sdu.algorithm.recruitment;

public class RM01_05 {

    private static boolean oneEditAway(String first, String second) {
        // dp[i][j]: 字符串(0, i) 转为字符串(0, j)的最小变化次数
        // dp[i][j] = dp[i - 1][j - 1], 若 s(i) = s(j)
        //                          插入          删除             替换
        // dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]) + 1, 若 s(i) != s(j)
        int n = first.length(), m = second.length();
        int[][] dp = new int[n + 1][m + 1];

        // 初始化
        for (int i = 0; i <= n; i++) dp[i][0] = i;
        for (int j = 0; j <= m; j++) dp[0][j] = j;

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[n][m] <= 1;
    }

    public static void main(String[] args) {
        System.out.println(oneEditAway("pale", "ple"));
        System.out.println(oneEditAway("pales", "pal"));
    }

}
