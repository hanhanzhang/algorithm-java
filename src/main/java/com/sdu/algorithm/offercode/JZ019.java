package com.sdu.algorithm.offercode;

import java.util.ArrayList;

public class JZ019 {

  private static ArrayList<Integer> printMatrix(int [][] matrix) {
    int visited = matrix.length * matrix[0].length;
    ArrayList<Integer> ans = new ArrayList<>();
    int[][] moved = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    int i = 0, j = 0;
    int pos = 0;
    while (visited != ans.size()) {
      if (i < 0 || i > matrix.length - 1 || j < 0 || j > matrix[0].length - 1) {
        // 还原
        i -= moved[pos][0];
        j -= moved[pos][1];
        pos = ++pos % 4;
        i += moved[pos][0];
        j += moved[pos][1];
        continue;
      }
      if (matrix[i][j] == Integer.MIN_VALUE) {
        // 已访问过, 则需要调整方向
        i -= moved[pos][0];
        j -= moved[pos][1];
        pos = ++pos % 4;
        i += moved[pos][0];
        j += moved[pos][1];
        continue;
      }
      ans.add(matrix[i][j]);
      // 标记访问
      matrix[i][j] = Integer.MIN_VALUE;
      i += moved[pos][0];
      j += moved[pos][1];
    }

    return ans;
  }

  public static void main(String[] args) {
    int[][] matrix = new int[][] {
        {1,   2,  3, 4},
        {10, 11, 12, 5},
        {9,   8,  7, 6}
    };
    System.out.println(printMatrix(matrix));

    int[][] matrix1 = new int[][] {
        {1,   2,  3, 4},
        {12, 13, 14, 5},
        {11, 16, 15, 6},
        {10,  9,  8, 7}
    };
    System.out.println(printMatrix(matrix1));
  }

}
