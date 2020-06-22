package com.sdu.algorithm.offercode;

public class JZ028 {

  private static int MoreThanHalfNum_Solution(int [] array) {
    // 摩尔投票算法
    int voted = 1;
    int element = array[0];
    for (int i = 1; i < array.length; ++i) {
      voted = element == array[i] ? voted + 1 : voted - 1;
      if (voted == 0) {
        voted = 1;
        element = array[i];
      }
    }

    int cnt = 0;
    for (int num : array) {
      if (element == num) {
        cnt += 1;
      }
    }
    if (cnt > array.length / 2) {
      return element;
    }
    return 0;
  }

  public static void main(String[] args) {
    System.out.println(MoreThanHalfNum_Solution(new int[] {1, 2, 3, 2, 2, 2, 5, 4, 2}));
  }

}
