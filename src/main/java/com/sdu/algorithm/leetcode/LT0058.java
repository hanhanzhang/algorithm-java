package com.sdu.algorithm.leetcode;

public class LT0058 {

  private static int lengthOfLastWord(String s) {
    // 从后向前找更简单, 要找最后一个单词的长度
    if (s == null || s.isEmpty()) return 0;

    // 第一个不是' '的位置
    int end = s.length() - 1;
    while (end >= 0 && s.charAt(end) == ' ') {
      end--;
    }

    int start = end;
    while (start >= 0 && s.charAt(start) != ' ') {
      --start;
    }

    return end - start;
  }

  public static void main(String[] args) {
    System.out.println(lengthOfLastWord("Hello Chinese"));
    System.out.println(lengthOfLastWord("b a  "));
  }

}
