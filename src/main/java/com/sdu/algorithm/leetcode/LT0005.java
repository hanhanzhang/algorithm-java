package com.sdu.algorithm.leetcode;

public class LT0005 {

  private static String longestPalindrome(String s) {
    if (s.isEmpty()) {
      return "";
    }
    String reverse = new StringBuffer(s).reverse().toString();
    int length = s.length();
    int[] arr = new int[length];
    int maxLen = 0;
    int maxEnd = 0;
    for (int i = 0; i < length; i++) {
      for (int j = length - 1; j >= 0; j--) {
        if (s.charAt(i) == reverse.charAt(j)) {
          if (i == 0 || j == 0) {
            arr[j] = 1;
          } else {
            arr[j] = arr[j - 1] + 1;
          }
        } else {
          arr[j] = 0;
        }
        if (arr[j] > maxLen) {
          int beforeRev = length - 1 - j;
          if (beforeRev + arr[j] - 1 == i) {
            maxLen = arr[j];
            maxEnd = i;
          }
        }
      }
    }

    return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
  }

  public static void main(String[] args) {
    System.out.println(longestPalindrome("babad"));
    System.out.println(longestPalindrome("cbbd"));
    System.out.println(longestPalindrome("aacabdkacaa"));
  }

}
