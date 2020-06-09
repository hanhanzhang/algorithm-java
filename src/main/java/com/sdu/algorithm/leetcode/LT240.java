package com.sdu.algorithm.leetcode;

public class LT240 {

  private static boolean search(int[][]matrix, int x1, int y1, int x2, int y2, int target) {
    if (x1 > x2 || y1 > y2 || matrix[x1][y1] > target || matrix[x2][y2] < target) {
      return false;
    }
    
    int midX = (x1 + x2) / 2;
    int midY = (y1 + y2) / 2;
    if (matrix[midX][midY] == target) {
      return true;
    }

    if (matrix[midX][midY] < target) {
      return search(matrix, x1, midY, midX, y2, target)
          || search(matrix, midX, y1, x2, midY, target)
          || search(matrix, midX, midY, x2, y2, target);
    }

    return search(matrix, x1, midY, midX, y2, target)
        || search(matrix, midX, y1, x2, midY, target)
        || search(matrix, x1, y1, midX, midY, target);
  }

  private static boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null) {
      return false;
    }
    return search(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, target);
  }

  public static void main(String[] args) {
    int[][] matrix = new int[][] {
        {1,   4,  7, 11, 15},
        {2,   5,  8, 12, 19},
        {3,   6,  9, 16, 22},
        {10, 13, 14, 17, 24},
        {18, 21, 23, 26, 30}
    };
    System.out.println(searchMatrix(matrix, 5));
  }

}
