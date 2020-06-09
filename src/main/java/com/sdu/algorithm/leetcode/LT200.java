package com.sdu.algorithm.leetcode;

public class LT200 {

  private static void dfs(char[][] grid, int i, int j) {
    if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '3' || grid[i][j] == '0') {
      return;
    }
    grid[i][j] = '3';
    dfs(grid, i - 1, j);
    dfs(grid, i + 1, j);
    dfs(grid, i, j - 1);
    dfs(grid, i, j + 1);
  }

  private static int numIslands(char[][] grid) {
    // 寻找与'1'连通的区域个数, 3表示已连通
    int lands = 0;
    for (int i = 0; i < grid.length; ++i) {
      for (int j = 0; j < grid[i].length; ++j) {
        if (grid[i][j] == '1') {
          // 开始寻找新的岛屿
          lands += 1;
          dfs(grid, i, j);
        }
      }
    }
    return lands;
  }

  public static void main(String[] args) {
    char[][] grid = new char[][] {
        {'1', '1', '1', '1', '0'},
        {'1', '1', '0', '1', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '0', '0', '0'}
    };

    char[][] grid1 = new char[][] {
        {'1', '1', '0', '0', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '1', '0', '0'},
        {'0', '0', '0', '1', '1'}
    };

    System.out.println(numIslands(grid));
    System.out.println(numIslands(grid1));


  }

}
