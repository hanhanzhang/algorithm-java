package com.sdu.algorithm.leetcode;

/**
 * 一个机器人位于一个 m x n 网格的左上角(起始点在下图中标记为'Start' )
 *
 * 机器人每次只能向下或者向右移动一步, 机器人试图达到网格的右下角(在下图中标记为'Finish')
 *
 * 问总共有多少条不同的路径
 *
 * */
public class LT062 {

  // 递归
  private static int uniquePaths(int m, int n) {
    if (m <= 0 || n <= 0) {
      return 0;
    }
    if (m == 1 && n == 1) {
      return 1;
    }
    return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
  }

  // 非递归
  private static int uniquePaths01(int m, int n) {
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        if (i == 0 && j == 0) {
          dp[i][j] = 0;
        } else if (i == 0 || j == 0) {
          dp[i][j] = 1;
        } else {
          dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
      }
    }

    return dp[m - 1][n - 1];
  }

  public static void main(String[] args) {
    System.out.println(uniquePaths01(7, 3));
  }

}
