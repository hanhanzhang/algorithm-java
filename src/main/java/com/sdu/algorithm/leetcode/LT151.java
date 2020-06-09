package com.sdu.algorithm.leetcode;

import java.util.Stack;

public class LT151 {

  private static String reverseWords(String s) {
    if (s == null || s.isEmpty()) return "";

    Stack<String> stack = new Stack<>();

    int start = 0;
    while (start < s.length()) {
      while (start < s.length() && s.charAt(start) == ' ') ++start;
      int end = start;
      while (end < s.length() && s.charAt(end) != ' ') ++end;
      if (start < s.length()) {
        stack.push(s.substring(start, end));
        start = end;
      }
    }

    StringBuilder sb = new StringBuilder();
    boolean first = true;
    while (!stack.isEmpty()) {
      if (first) {
        sb.append(stack.pop());
        first = false;
      } else {
        sb.append(" ");
        sb.append(stack.pop());
      }
    }
    return String.join("", stack);
  }

  public static void main(String[] args) {
    System.out.println(reverseWords("the sky is blue"));
    System.out.println(reverseWords("  hello world!  "));
    System.out.println(reverseWords("a good   example"));
  }

}
