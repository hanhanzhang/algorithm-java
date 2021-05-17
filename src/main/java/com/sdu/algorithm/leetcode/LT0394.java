package com.sdu.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LT0394 {

  private static String decodeString(String s) {
    if (s == null || s.isEmpty()) {
      return s;
    }
    // 类似计算表达式, 栈实现
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); ++i) {
      char c = s.charAt(i);
      if (c == ']') {
        // 出栈直至碰到数字
        List<Character> chars = new ArrayList<>();
        int repeat = 0;
        while (!stack.isEmpty()) {
          char cc = stack.pop();
          if (cc == '[') {
            int multi = 0;
            while (!stack.isEmpty()) {
              // 重复次数, 如: 2, 10, 100
              char n = stack.peek();
              if (n >= '0' && n <= '9') {
                int nc = (int) stack.pop() - (int) '0';
                repeat += nc * Math.pow(10, multi++);
                continue;
              }
              break;
            }
            break;
          }
          chars.add(cc);
        }

        // 重复
        for (int k = 0; k < repeat; ++k) {
          for (int m = chars.size() - 1; m >= 0; --m) {
            stack.push(chars.get(m));
          }
        }
      } else {
        stack.push(c);
      }
    }

    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }

    return sb.reverse().toString();
  }

  public static void main(String[] args) {
    System.out.println(decodeString("3[a]2[bc]"));
    System.out.println(decodeString("3[a2[c]]"));
    System.out.println(decodeString("2[abc]3[cd]ef"));
    System.out.println(decodeString("100[leetcode]"));
  }

}
