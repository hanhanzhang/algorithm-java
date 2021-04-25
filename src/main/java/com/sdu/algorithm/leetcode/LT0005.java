package com.sdu.algorithm.leetcode;

public class LT0005 {

  private static String longestPalindrome(String s) {
    // dp[i][j]: s[i]~s[j]为回文串
    // dp[i][j] = dp[i + 1][j - 1] && s[j] == s[j]
    if (s.length() < 2) return s;
    boolean[][] dp = new boolean[s.length()][s.length()];
    for (int i = 0; i < s.length(); ++i) {
      dp[i][i] = true;
    }

    return null;
  }

  public static void main(String[] args) {
    System.out.println(longestPalindrome("babad"));
    System.out.println(longestPalindrome("cbbd"));
    System.out.println(longestPalindrome("aacabdkacaa"));
  }

}
