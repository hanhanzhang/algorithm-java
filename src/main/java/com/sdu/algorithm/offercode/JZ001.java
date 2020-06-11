package com.sdu.algorithm.offercode;

public class JZ001 {

  private static boolean Find(int target, int [][] array) {
    if (array == null || array.length == 0) {
      return false;
    }
    // 对角线方式查找, 折半无法解决
    int row = 0, col = array[0].length - 1;
    while (col >= 0 && row <= array.length - 1) {
      if (target == array[row][col]) {
        return true;
      } else if (target > array[row][col]) {
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
    int[][] array = new int[][] {
        {1,  4,  7, 11, 15},
        {2,  5,  8, 12, 19},
        {3,  6,  9, 16, 22},
        {10, 13, 14, 17, 24},
        {18, 21, 23, 26, 30}
    };
    System.out.println(Find(5, array));
  }

}
