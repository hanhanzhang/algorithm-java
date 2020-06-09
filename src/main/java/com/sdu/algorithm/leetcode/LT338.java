package com.sdu.algorithm.leetcode;

public class LT338 {

  private static int[] countBits(int num) {
    int[] ans = new int[num + 1];
    ans[0] = 0;
    for (int i = 1; i <= num; ++i) {
      int cnt = 0;
      int tmp = i;
      while (tmp != 0) {
        cnt += (tmp & 1) == 0 ? 0 : 1;
        tmp = tmp >> 1;
      }
      ans[i] = cnt;
    }
    return ans;
  }

  private static int[] countBits1(int num) {
    // TODO: 动态规划
    return null;
  }

  public static void main(String[] args) {
    // 2 -> [0, 1, 1]
    int[] ans = countBits(2);
    for (int a : ans) {
      System.out.println(a);
    }
    System.out.println("******");
    // 5 -> [0, 1, 1, 2, 1, 2]
    int[] ans1 = countBits(5);
    for (int a : ans1) {
      System.out.println(a);
    }
  }

}
