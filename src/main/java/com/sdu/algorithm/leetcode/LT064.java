package com.sdu.algorithm.leetcode;

/**
 * 给定一个包含非负整数的 m x n 网格, 请找出一条从左上角到右下角的路径, 使得路径上的数字总和为最小.
 *
 * 说明: 每次只能向下或者向右移动一步
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 *
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小
 * */
public class LT064 {

  // 递归方式
  private static int minPathSum(int[][] grid, int i, int j) {
    if (i == 0 && j == 0) {
      return grid[0][0];
    }

    if (i > 0) {
      return j > 0 ? Math.min(grid[i][j] + minPathSum(grid, i - 1, j),
                              grid[i][j] + minPathSum(grid, i , j - 1))
                   : grid[i][j] + minPathSum(grid, i - 1, j);
    }

    return grid[i][j] + minPathSum(grid, i, j - 1);
  }


  private static int minPathSum(int[][] grid) {
    return minPathSum(grid, grid.length - 1, grid[0].length - 1);
  }

  // 非递归方式(动态规划, 需要额外的存储空间)
  private static int minPathSum0(int[][]grid) {
    int[][] dp = new int[grid.length][grid[0].length];

    for (int i = 0; i < grid.length; ++i) {
      for (int j = 0; j < grid[i].length; ++j) {
        if (i == 0 && j == 0) {
          dp[i][j] = grid[i][j];
        } else if (i > 0) {
          dp[i][j] = j > 0 ? Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
                           : dp[i - 1][j] + grid[i][j];
        } else {
          dp[i][j] = grid[i][j] + dp[i][j - 1];
        }
      }
    }
    return dp[grid.length - 1][grid[0].length - 1];
  }

  // 非递归方式(动态规划, O(1)存储空间)
  private static int minPathSum1(int[][]grid) {
    for (int i = 0; i < grid.length; ++i) {
      for (int j = 0; j < grid[i].length; ++j) {
        if (i == 0 && j == 0) {
          continue;
        }
        if (i > 0) {
          grid[i][j] = j > 0 ? Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j]
                             : grid[i - 1][j] + grid[i][j];
          continue;
        }

        grid[i][j] = grid[i][j] + grid[i][j - 1];
      }
    }
    return grid[grid.length - 1][grid[0].length - 1];
  }

  public static void main(String[] args) {
    int[][] grid = new int[][] {
        {1, 3, 1},
        {1, 5, 1},
        {4, 2, 1}
    };

    System.out.println(minPathSum1(grid));
  }

}
