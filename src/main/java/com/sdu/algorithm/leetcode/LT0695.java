package com.sdu.algorithm.leetcode;

public class LT0695 {

  private static int dfs(int[][] grid, int x, int y) {
    if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || grid[x][y] != 1) {
      return 0;
    }
    // 标记已访问
    grid[x][y] = 2;
    return 1 + dfs(grid, x + 1, y) + dfs(grid, x - 1, y)
             + dfs(grid, x, y + 1) + dfs(grid, x, y - 1);
  }

  private static int maxAreaOfIsland(int[][] grid) {
    if (grid == null || grid.length == 0) return 0;
    int ans = 0;
    for (int i = 0; i < grid.length; ++i) {
      for (int j = 0; j < grid[i].length; ++j) {
        if (grid[i][j] == 1) {
          ans = Math.max(ans, dfs(grid, i, j));
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[][] grid = new int[][] {
        {0, 0, 0, 0, 0}
    };
    System.out.println(maxAreaOfIsland(grid));

    int[][] grid1 = new int[][] {
            {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
    };
    System.out.println(maxAreaOfIsland(grid1));
  }

}
