package com.sdu.algorithm.leetcode;

public class LT0062 {

  private static int uniquePaths(int m, int n) {
    int[][]dp = new int[m][n];
    dp[0][0] = 1;
    for (int i = 1; i < n; ++i) dp[0][i] = dp[0][i - 1];
    for (int i = 1; i < m; ++i) dp[i][0] = dp[i - 1][0];
    for (int i = 1; i < m; ++i) {
      for (int j = 1; j < n; ++j) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }
    return dp[m - 1][n - 1];
  }

  public static void main(String[] args) {
    System.out.println(uniquePaths(3, 7));
    System.out.println(uniquePaths(5, 2));
  }

}
