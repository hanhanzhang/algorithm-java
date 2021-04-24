package com.sdu.algorithm.leetcode;

public class LT0240 {


  private static boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0) {
      return false;
    }
    // 对角线方式查找, 折半无法解决
    int row = 0, col = matrix[0].length - 1;
    while (col >= 0 && row <= matrix.length - 1) {
      if (target == matrix[row][col]) {
        return true;
      } else if (target > matrix[row][col]) {
        // 当前行肯定不存在
        row += 1;
      } else {
        // 当前列肯定不存在
        col -= 1;
      }
    }
    return false;
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
