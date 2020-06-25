package com.sdu.algorithm.offercode;

public class JZ065 {

  private static boolean hasPath(char[][]matrix, int i, int j, char[] str, int pos, int[][] visited) {
    if (pos >= str.length) {
      return true;
    }
    if (i < 0 || i > matrix.length - 1 || j < 0 || j > matrix[0].length - 1
        || visited[i][j] == 1 || matrix[i][j] != str[pos]) {
      return false;
    }
    visited[i][j] = 1;
    boolean ans = hasPath(matrix, i - 1, j, str, pos + 1, visited)
        || hasPath(matrix, i + 1, j, str, pos + 1, visited)
        || hasPath(matrix, i, j - 1, str, pos + 1, visited)
        || hasPath(matrix, i, j + 1, str, pos + 1, visited);
    // 回溯
    if (!ans) {
      visited[i][j] = 0;
    }

    return ans;
  }

  private static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
    if (matrix == null || matrix.length == 0 || matrix.length < str.length) {
      return false;
    }
    char[][] mat = new char[rows][cols];
    int m = 0;
    for (int i = 0; i < rows; ++i) {
      for (int j = 0; j < cols; ++j) {
        mat[i][j] = matrix[m++];
      }
    }

    for (int i = 0; i < rows; ++i) {
      for (int j = 0; j < cols; ++j) {
        if (mat[i][j] == str[0]) {
          boolean isOk = hasPath(mat, i, j, str, 0, new int[rows][cols]);
          if (isOk) {
            return true;
          }
        }
      }
    }

    return false;
  }

  public static void main(String[] args) {
    char[] matrix = "abcesfcsadee".toCharArray();
    System.out.println(hasPath(matrix, 3, 4, "bcced".toCharArray()));
    System.out.println(hasPath(matrix, 3, 4, "abcb".toCharArray()));
  }

}
