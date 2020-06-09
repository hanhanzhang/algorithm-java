package com.sdu.algorithm.offercode;

import java.util.ArrayDeque;
import java.util.Queue;

public class JZ065 {

  private static boolean dfs(char[][]matrix, int i, int j, int[][] visited, String word, int pos) {
    if (i < 0 || i > matrix.length - 1 || j < 0 || j > matrix[0].length - 1 || visited[i][j] == 1) {
      return false;
    }
    if (pos >= word.length()) {
      return true;
    }
    if (matrix[i][j] != word.charAt(pos)) {
      return false;
    }
    visited[i][j] = 1;
    boolean ans = dfs(matrix, i - 1, j, visited, word, pos + 1)
               || dfs(matrix, i + 1, j, visited, word, pos + 1)
               || dfs(matrix, i, j - 1, visited, word, pos + 1)
               || dfs(matrix, i, j + 1, visited, word, pos + 1);
    // 回溯
    visited[i][j] = ans ? 1 : 0;
    return ans;
  }

  private static boolean hasPath(char[][] matrix, String word) {
    if (word == null || word.isEmpty()) {
      return false;
    }
    char c = word.charAt(0);
    Queue<int[]> queue = new ArrayDeque<>();
    for (int i = 0; i < matrix.length; ++i) {
      for (int j = 0; j < matrix[i].length; ++j) {
        if (matrix[i][j] == c) {
          queue.offer(new int[] {i, j});
        }
      }
    }

    int[][] visited = new int[matrix.length][matrix[0].length];
    while (!queue.isEmpty()) {
      int[] start = queue.poll();
      if (dfs(matrix, start[0], start[1], visited, word, 0)) {
        return true;
      }
    }

    return false;
  }

  public static void main(String[] args) {

    char[][] matrix = new char[][] {
        {'a', 'b', 'c', 'e'},
        {'s', 'f', 'c', 's'},
        {'a', 'd', 'e', 'e'}
    };

    System.out.println(hasPath(matrix, "bcced"));
    System.out.println(hasPath(matrix, "abcd"));
  }

}
