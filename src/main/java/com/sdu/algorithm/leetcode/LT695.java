package com.sdu.algorithm.leetcode;

public class LT695 {

  private static int dfs(int[][]grid, int i, int j, int[][] visited) {
    if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[i].length - 1
        || visited[i][j] == 1 || grid[i][j] == 0) {
      return 0;
    }
    visited[i][j] = 1;
    int land = 1;
    land += dfs(grid, i - 1, j, visited);
    land += dfs(grid, i + 1, j, visited);
    land += dfs(grid, i, j - 1, visited);
    land += dfs(grid, i, j + 1, visited);
    return land;
  }

  private static int maxAreaOfIsland(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    int[][] visited = new int[grid.length][grid[0].length];
    int maxLand = 0;
    for (int i = 0; i < grid.length; ++i) {
      for (int j = 0; j < grid[i].length; ++j) {
        if (grid[i][j] == 1 && visited[i][j] == 0) {
          maxLand = Math.max(maxLand, dfs(grid, i, j, visited));
        }
      }
    }
    return maxLand;
  }

  public static void main(String[] args) {
    int[][] grid = new int[][] {
        {0, 0, 0, 0, 0}
    };
    System.out.println(maxAreaOfIsland(grid));

    int[][] grid1 = new int[][] {
        {1, 0, 0, 1},
        {1, 0, 0, 1},
        {0, 1, 0, 1}
    };
    System.out.println(maxAreaOfIsland(grid1));
  }

}
