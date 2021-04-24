package com.sdu.algorithm.offercode;

public class JZ001 {

  private static boolean Find(int target, int [][] array) {
    if (array == null || array.length == 0) {
      return false;
    }
    int row = 0, col = array[0].length - 1;
    while (row < array.length && col >=0) {
      int element = array[row][col];
      if (element == target) {
        return true;
      }
      if (element > target) {
        col -= 1;
      } else {
        row += 1;
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
    System.out.println(Find(31, array));
  }

}
