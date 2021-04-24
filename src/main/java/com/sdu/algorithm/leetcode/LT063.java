package com.sdu.algorithm.leetcode;

public class LT063 {

  private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
    if (obstacleGrid[0][0] == 1) {
      return 0;
    }

    for (int i = 0; i < obstacleGrid.length; ++i) {
      for (int j = 0; j < obstacleGrid[i].length; ++j) {
        if (obstacleGrid[i][j] == 1) {
          dp[i][j] = 0;
          continue;
        }
        if (i >= 1) {
          dp[i][j] = j >= 1 ? dp[i - 1][j] + dp[i][j - 1]
                            : dp[i - 1][j];
        } else {
          dp[i][j] = j >= 1 ? dp[i][j - 1]
                            : 1;
        }
      }
    }
    return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
  }

  public static void main(String[] args) {

    int[][] obstacleGrid = new int[][] {
        {0, 0},
        {1, 1},
        {0, 0}
    };

    System.out.println(uniquePathsWithObstacles(obstacleGrid));
  }

}
