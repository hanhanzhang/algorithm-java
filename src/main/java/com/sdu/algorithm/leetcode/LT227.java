package com.sdu.algorithm.leetcode;

import java.util.Stack;

public class LT227 {

  private static int calculate(String s) {
    Stack<Integer> stack = new Stack<>();
    int pos = 0;
    boolean selectOp = false;
    boolean compute = false;
    while (pos < s.length()) {
      if (selectOp) {
        int start = pos;
        while (start < s.length() && s.charAt(start) == ' ') ++start;
        if (start >= s.length()) break;
        char op = s.charAt(start);
        compute = op == '*' || op == '/';
        stack.push((int) op - (int) '0');
        pos = start + 1;
        selectOp = false;
      } else {
        int start = pos;
        while (start < s.length() && s.charAt(start) == ' ') ++start;
        if (start >= s.length()) break;
        int end = start;
        while (end < s.length() && s.charAt(end) != '+'
            && s.charAt(end) != '-' && s.charAt(end) != '*'
            && s.charAt(end) != '/' && s.charAt(end) != ' ') ++end;
        int ele = Integer.parseInt(s.substring(start, end));
        if (compute) {
          int op = stack.pop();
          int pre = stack.pop();
          if (op == '/' - '0') {
            ele = pre / ele;
          } else {
            ele = pre * ele;
          }
        }
        stack.push(ele);
        pos = end;
        selectOp = true;
      }
    }

    Stack<Integer> reverser = new Stack<>();
    while (!stack.isEmpty()) {
      reverser.push(stack.pop());
    }

    int ans = reverser.isEmpty() ? 0 : reverser.pop();
    while (!reverser.isEmpty()) {
      int op = reverser.pop();
      if (op == '+' - '0') {
        ans += reverser.pop();
      } else {
        ans = ans - reverser.pop();
      }
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
