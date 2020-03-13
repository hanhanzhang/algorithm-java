package com.sdu.algorithm.search;

import java.util.ArrayDeque;
import java.util.Queue;

public class BFS994 {

  private static int orangesRotting(int[][] grid) {

    Queue<int[]> badOranges = new ArrayDeque<>();
    int[][] visited = new int[grid.length][];

    for (int i = 0; i < grid.length; ++i) {
      visited[i] = new int[grid[i].length];
      for (int j = 0; j < grid[i].length; ++j) {
        if (grid[i][j] == 2) {  // 烂橘子
          badOranges.offer(new int[] {i, j});
          visited[i][j] = 1;
        }
      }
    }

    int minutes = 0;

    int cur = badOranges.size();
    int next = 0;
    int visit = 0;
    boolean toBad = false;
    while (!badOranges.isEmpty()) {
      int[] pos = badOranges.poll();
      visit += 1;

      // 若四个方向可使得有其他橘子腐烂, 则 minutes + 1(必须是同一层, 类似二叉树)
      if (pos[0] >= 1 && grid[pos[0] - 1][pos[1]] == 1 && visited[pos[0] - 1][pos[1]] == 0) {
        toBad = true;
        badOranges.offer(new int[] {pos[0] - 1, pos[1]});
        visited[pos[0] - 1][pos[1]] = 1;
        next += 1;
      }
      if (pos[0] + 1 < grid.length && grid[pos[0] + 1][pos[1]] == 1 && visited[pos[0] + 1][pos[1]] == 0) {
        toBad = true;
        badOranges.offer(new int[] {pos[0] + 1, pos[1]});
        visited[pos[0] + 1][pos[1]] = 1;
        next += 1;
      }
      if (pos[1] >= 1 && grid[pos[0]][pos[1] - 1] == 1 && visited[pos[0]][pos[1] - 1] == 0) {
        toBad = true;
        badOranges.offer(new int[] {pos[0], pos[1] - 1});
        visited[pos[0]][pos[1] - 1] = 1;
        next += 1;
      }
      if (pos[1] + 1 < grid[pos[0]].length && grid[pos[0]][pos[1] + 1] == 1 && visited[pos[0]][pos[1] + 1] == 0) {
        toBad = true;
        badOranges.offer(new int[] {pos[0], pos[1] + 1});
        visited[pos[0]][pos[1] + 1] = 1;
        next += 1;
      }

      if (toBad && visit == cur) {
        minutes += 1;
        cur = next;
        visit = 0;
        next = 0;
        toBad = false;
      }
    }

    boolean notVisited = false;
    for (int i = 0; i < visited.length; ++i) {
      for (int j = 0; j < visited[i].length; ++j) {
        if (visited[i][j] == 0 && grid[i][j] != 0) {
          notVisited = true;
          break;
        }
      }
      if (notVisited) {
        break;
      }
    }

    return notVisited ? - 1: minutes;
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

    System.out.println(orangesRotting(grid0));
    System.out.println(orangesRotting(grid1));
    System.out.println(orangesRotting(grid2));
    System.out.println(orangesRotting(grid3));
    System.out.println(orangesRotting(grid4));
  }

}
