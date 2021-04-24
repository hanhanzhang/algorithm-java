package com.sdu.algorithm.leetcode;

public class LT461 {

  private static int hammingDistance(int x, int y) {
    int res = x ^ y;
    // 判断比特位是1的个数
    int ans = 0;
    while (res != 0) {
      if ((res & 1) == 1) {
        ans += 1;
      }
      res = res >> 1;
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(hammingDistance(1, 4));
    System.out.println(hammingDistance(2, 5));
  }

}
