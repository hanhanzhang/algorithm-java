package com.sdu.algorithm.string;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LT022 {


  private static boolean isValid(char[] chars) {
    if (chars == null || chars.length == 0) return true;
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < chars.length; ++i) {
      char c = chars[i];
      if (c == '(') {
        stack.push(c);
        continue;
      }
      if (c == ')') {
        if (stack.isEmpty()) return false;
        stack.pop();
      }
    }
    return stack.isEmpty();
  }

  private static void generateParenthesis(int n, int charPos, char[] midResult, List<String> result) {
    if (charPos >= 2 * n) {
      if (isValid(midResult)) {
        result.add(new String(midResult));
      }
      return;
    }
    // 暴力穷举, 没有剪枝(中间结果无需拷贝)
    midResult[charPos] = '(';
    generateParenthesis(n, charPos + 1, midResult, result);
    midResult[charPos] = ')';
    generateParenthesis(n, charPos + 1, midResult, result);
  }

  private static List<String> generateParenthesis(int n) {
    if (n <= 0) return Collections.emptyList();

    LinkedList<String> result = new LinkedList<>();
    char[] midResult = new char[2 * n];
    generateParenthesis(n, 0, midResult, result);

    return result;
  }

  public static void main(String[] args) {
    List<String> result = generateParenthesis(3);
    for (String pattern : result) {
      System.out.println(pattern);
    }
  }

}
