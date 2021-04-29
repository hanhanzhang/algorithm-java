package com.sdu.algorithm.leetcode;

public class LT0005 {

  private static String longestPalindrome(String s) {
    if (s == null || s.isEmpty()) return "";
    return null;
  }

  public static void main(String[] args) {
    System.out.println(longestPalindrome("babad"));
    System.out.println(longestPalindrome("cbbd"));
    System.out.println(longestPalindrome("aacabdkacaa"));
  }

}
