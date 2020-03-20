package com.sdu.algorithm.dp;

/**
 * 给定一个字符串 s, 找到 s 中最长的回文子串. 你可以假设 s 的最大长度为 1000 .
 *
 * 示例 1:
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 * */
public class LT005 {

  private static boolean isPalindrome(char[] chars, int l, int h) {
    while (l <= h) {
      if (chars[l] != chars[h]) {
        return false;
      }
      l += 1;
      h -= 1;
    }
    return true;
  }

  private static String longestPalindrome(String s) {

    char[] chars = s.toCharArray();

    // f[i]表示回文串的起始位置
    int[] f = new int[chars.length];
    f[0] = chars[0];

    int maxPalindrome = 1;
    int pos = 0;
    f[pos] = 0;

    for (int i = 1; i < chars.length; ++i) {
      for (int j = 0; j <= i; ++j) {
        boolean palindrome = isPalindrome(chars, j, i);

        if (palindrome && i - j + 1 > maxPalindrome) {
          maxPalindrome = i - j +1;
          pos = i;
          f[i] = j;
        }
      }
    }

    return new String(chars, f[pos], pos - f[pos] + 1);

  }

  public static void main(String[] args) {

    // TODO: 不是最佳答案

    String s = "a";

    System.out.println(longestPalindrome(s));


  }

}
