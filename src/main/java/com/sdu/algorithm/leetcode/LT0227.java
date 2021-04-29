package com.sdu.algorithm.leetcode;

import java.util.Stack;

public class LT0227 {

  private static int calculate(String s) {
    Stack<Integer> stack = new Stack<>();
    char preOp = '+';
    int num = 0;
    for (int i = 0; i < s.length(); ++i) {
      char ch = s.charAt(i);
      if (Character.isDigit(ch)) {
        num = num * 10 + (ch - '0');
      }
      // 最后一个数字时, 需要计算
      if ((ch != ' ' && !Character.isDigit(ch)) || i == s.length() - 1) {
        switch (preOp) {
          case '+':
            stack.push(num);
            break;
          case '-':
            stack.push(-num);
            break;
          case '*':
            stack.push(stack.pop() * num);
            break;
          case '/':
            stack.push(stack.pop() / num);
            break;
        }
        num = 0;
        preOp = ch;
      }
    }

    int ans = 0;
    while (!stack.isEmpty()) {
      ans += stack.pop();
    }

    return ans;
  }

  public static void main(String[] args) {
    System.out.println(calculate("3+2*2"));
    System.out.println(calculate(" 3/2 "));
    System.out.println(calculate(" 3+5 / 2 "));
    System.out.println(calculate("0-2147483647"));
    System.out.println(calculate("1-1+1"));
  }

}
