package com.sdu.algorithm.leetcode;

public class LT0063 {

  private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int n = obstacleGrid.length, m = obstacleGrid[0].length;
    int[][] dp = new int[n][m];
    dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
    for (int i = 1; i < m; ++i) dp[0][i] = obstacleGrid[0][i] == 1 ? 0 : dp[0][i - 1];
    for (int i = 1; i < n; ++i) dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : dp[i - 1][0];
    for (int i = 1; i < n; ++i) {
      for (int j = 1; j < m; ++j) {
        if (obstacleGrid[i][j] == 1) {
          dp[i][j] = 0;
        } else {
          dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
        }
      }
    }
    return dp[n - 1][m - 1];
  }

  public static void main(String[] args) {
    int[][] obstacleGrid1 = new int[][] {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
    System.out.println(uniquePathsWithObstacles(obstacleGrid1));

    int[][] obstacleGrid2 = new int[][] {{0, 0}, {0, 1}};
    System.out.println(uniquePathsWithObstacles(obstacleGrid2));
  }

}
