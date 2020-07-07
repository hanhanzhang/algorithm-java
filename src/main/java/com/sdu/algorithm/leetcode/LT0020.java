package com.sdu.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LT0020 {

  private static boolean isValid(String s) {
    if (s == null || s.isEmpty()) return true;

    Map<Character, Character> mappings = new HashMap<>();
    mappings.put('(', ')');
    mappings.put('{', '}');
    mappings.put('[', ']');

    /*
     * 括号成对出现, 需要保留尚未匹配的括号, 匹配规则符合后进先出的规律, 故使用栈
     *
     * 1: 遇到左括号, 进栈
     *
     * 2: 遇到右括号, 出栈并判断是否有效
     * */
    Stack<Character> stack = new Stack<>();
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; ++i) {
      char c = chars[i];
      if (c == '(' || c == '[' || c == '{') {
        stack.push(c);
        continue;
      }
      if (c == ')' || c == ']' || c == '}') {
        if (stack.isEmpty()) return false;
        char p = stack.pop();
        char w = mappings.get(p);
        if (c != w) return false;
      }
    }

    return stack.isEmpty();
  }

  public static void main(String[] args) {
    System.out.println(isValid("()"));
    System.out.println(isValid("(]"));
  }

}
