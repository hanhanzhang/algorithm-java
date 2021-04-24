package com.sdu.algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class LT994 {

  private static int orangesRotting(int[][] grid) {

    Queue<int[]> badOranges = new ArrayDeque<>();
    int[][] visited = new int[grid.length][];

    int goodOranges = 0;
    for (int i = 0; i < grid.length; ++i) {
      visited[i] = new int[grid[i].length];
      for (int j = 0; j < grid[i].length; ++j) {
        if (grid[i][j] == 2) {  // 烂橘子
          badOranges.offer(new int[] {i, j});
          visited[i][j] = 1;
        } else if (grid[i][j] == 1) {
          goodOranges += 1;
        }
      }
    }

    int[][] moved = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    int minutes = -1;
    int toBadOranges = 0;
    while (!badOranges.isEmpty()) {
      int size = badOranges.size();
      for (int i = 0; i < size; ++i) {
        int[] badOrange = badOranges.poll();
        // 四个方向
        for (int m = 0; m  < moved.length; ++m) {
          int[] p = moved[m];
          int x = badOrange[0] + p[0];
          int y = badOrange[1] + p[1];
          if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || visited[x][y] == 1) {
            continue;
          }
          if (grid[x][y] == 1) {
            toBadOranges += 1;
            visited[x][y] = 1;
            badOranges.offer(new int[] {x, y});
          }
        }
      }
      minutes += 1;
    }

    return goodOranges == toBadOranges ? (minutes == -1 ? 0 : minutes) : -1;
  }

  public static void main(String[] args) {
    int[][] grid0 = new int[][] {
        {2, 1, 1},
        {1, 1, 0},
        {0, 1, 1}
    };

    int[][] grid1 = new int[][] {
        {2, 1, 1},
        {0, 1, 1},
        {1, 0, 1}
    };

    int[][] grid2 = new int[][] {
        {0, 2},
    };

    int[][] grid3 = new int[][] {
        {1, 2, 1, 1, 2, 1, 1}
    };

    int[][] grid4 = new int[][] {
        {2, 2},
        {1, 1},
        {0, 0},
        {2, 0}
    };

    int[][] grid5 = new int[][] {
        {0}
    };

    System.out.println(orangesRotting(grid0));
    System.out.println(orangesRotting(grid1));
    System.out.println(orangesRotting(grid2));
    System.out.println(orangesRotting(grid3));
    System.out.println(orangesRotting(grid4));
    System.out.println(orangesRotting(grid5));
  }

}
