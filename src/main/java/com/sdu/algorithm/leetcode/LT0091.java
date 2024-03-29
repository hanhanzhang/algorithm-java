package com.sdu.algorithm.leetcode;

public class LT0091 {

  private static int numDecodings(String s) {
    int n = s.length();
    int[] f = new int[n + 1];
    f[0] = 1;
    for (int i = 1; i <= n; ++i) {
      if (s.charAt(i - 1) != '0') {
        f[i] += f[i - 1];
      }
      if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
        f[i] += f[i - 2];
      }
    }
    return f[n];
  }

  public static void main(String[] args) {
    System.out.println(numDecodings("110"));
    System.out.println(numDecodings("12"));
  }

}
