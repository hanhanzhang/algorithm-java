package com.sdu.algorithm.offercode;

public class JZ010 {

  private static int RectCover(int target) {
    // dp[i] = dp[i - 1] + dp[i - 2]
    if (target == 0 || target == 1 || target == 2) {
      return target;
    }
    int a = 1, b = 2, c = 0;
    for (int i = 3; i <= target; ++i) {
      c = a + b;
      a = b;
      b = c;
    }
    return c;
  }

  public static void main(String[] args) {
    System.out.println(RectCover(10));
    System.out.println(RectCover(9));
    System.out.println(RectCover(7));
  }

}
