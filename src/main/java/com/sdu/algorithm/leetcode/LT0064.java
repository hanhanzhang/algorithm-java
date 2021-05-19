package com.sdu.algorithm.leetcode;

public class LT0064 {

  private static int minPathSum(int[][] grid) {
    int n = grid.length, m = grid[0].length;
    //                          向左          向右
    // dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
    int[][] dp = new int[n][m];
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < m; ++j) {
        if (i == 0 && j == 0) dp[i][j] = grid[i][j];
        else if (i == 0) dp[i][j] = dp[i][j - 1] + grid[i][j];
        else if (j == 0) dp[i][j] = dp[i - 1][j] + grid[i][j];
        else dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
      }
    }
    return dp[n - 1][m - 1];
  }

  public static void main(String[] args) {
    int[][] grid1 = new int[][] {
        {1, 3, 1},
        {1, 5, 1},
        {4, 2, 1}
    };
    System.out.println(minPathSum(grid1));

    int[][] grid2 = new int[][] {
            {1, 2, 3},
            {4, 5, 6}
    };
    System.out.println(minPathSum(grid2));
  }

}
