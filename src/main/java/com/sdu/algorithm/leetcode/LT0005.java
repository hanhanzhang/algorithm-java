package com.sdu.algorithm.leetcode;

public class LT0005 {

  private static String longestPalindrome(String s) {
    // 区间动态规划
    int n = s.length();
    boolean[][] dp = new boolean[n][n];
    int pos = 0, maxLen = 1;
    for (int i = 0; i < n; ++i) dp[i][i] = true;
    for (int len = 2; len <= n; ++len) {
      for (int l = 0; l + len - 1 < n; ++l) {
        int r = l + len - 1;
        if (s.charAt(l) == s.charAt(r)) {
          dp[l][r] = r - l < 3 || dp[l + 1][r - 1];
        } else {
          dp[l][r] = false;
        }
        if (dp[l][r] && (r - l + 1) > maxLen) {
          pos = l;
          maxLen = r - l + 1;
        }
      }
    }
    return s.substring(pos, pos + maxLen);
  }

  public static void main(String[] args) {
    System.out.println(longestPalindrome("babad"));
    System.out.println(longestPalindrome("cbbd"));
    System.out.println(longestPalindrome("aacabdkacaa"));
    System.out.println(longestPalindrome("ac"));
  }

}
