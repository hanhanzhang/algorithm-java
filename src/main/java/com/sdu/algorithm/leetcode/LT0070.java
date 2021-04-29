package com.sdu.algorithm.leetcode;

public class LT0070 {

  private static int climbStairs(int n) {
    if (n == 1 || n == 2) return n;
    int ans = 0;
    int k2 = 1, k1 = 2;
    for (int i = 3; i <= n; ++i) {
      ans = k1 + k2;
      k2 = k1;
      k1 = ans;
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(climbStairs(3));
    System.out.println(climbStairs(5));

  }

}
