package com.sdu.algorithm.recruitment;

import java.util.Stack;

public class RM0003 {


  private static int calculate(String pattern) {
    // 可以使用双栈解决(一个栈存储数字, 一个栈存储运算符, 从后向前扫描)
    // 这里使用单栈处理, 减法变加法运算(换成负数)
    Stack<Integer> stack = new Stack<>();
    char operator = '+';
    int number = 0;
    for (int i = 0; i < pattern.length(); ++i) {
      char c = pattern.charAt(i);
      // '+', '-', '*', '/'  < '0'
      if (c >= '0') {
        number = number * 10 + c - '0';
      }

      if (c < '0') {
        switch (operator) {
          case '+':
            stack.push(number);
            break;
          case '-':
            stack.push(-number);
            break;
          case '*':
            stack.push(stack.pop() * number);
            break;
          case '/':
            stack.push(stack.pop() / number);
            break;
        }
        operator = c;
        number = 0;
      }
    }

    // 计算加法
    int ret = 0;
    while (!stack.isEmpty()) {
      ret += stack.pop();
    }

    return ret;
  }

  public static void main(String[] args) {
    System.out.println(calculate("9/3+5*2-6"));
  }

}
