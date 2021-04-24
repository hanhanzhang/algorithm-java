package com.sdu.algorithm.offercode;

public class JZ066 {

  private static boolean canReach(int threshold, int m, int n) {
    int sum = 0;
    while (m != 0) {
      sum += m % 10;
      m = m / 10;
    }
    while (n != 0) {
      sum += n % 10;
      n = n / 10;
    }
    return sum <= threshold;
  }

  private static int dfs(int threshold, int row, int cols, int i, int j, int[][] visited) {
    if (i < 0 || i > row - 1 || j < 0 || j > cols - 1 || visited[i][j] == 1) {
      return 0;
    }
    if (!canReach(threshold, i, j)) {
      return 0;
    }
    visited[i][j] = 1;
    return 1 + dfs(threshold, row, cols, i + 1, j, visited)
        + dfs(threshold, row, cols, i - 1, j, visited)
        + dfs(threshold, row, cols, i, j + 1, visited)
        + dfs(threshold, row, cols, i, j - 1, visited);
  }

  private static int movingCount(int threshold, int rows, int cols) {
    return dfs(threshold, rows, cols, 0, 0, new int[rows][cols]);
  }

  public static void main(String[] args) {
    System.out.println(movingCount(18, 4, 5));
    System.out.println(movingCount(19, 6, 7));
    System.out.println(movingCount(10, 1, 100));
  }

}
