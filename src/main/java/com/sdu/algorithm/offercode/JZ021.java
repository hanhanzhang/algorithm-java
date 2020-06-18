package com.sdu.algorithm.offercode;

import java.util.Stack;

public class JZ021 {

  private static boolean IsPopOrder(int[] pushA, int[] popA) {
    Stack<Integer> stack = new Stack<>();

    int i = 0, j = 0;
    while (i  < pushA.length) {
      if (pushA[i] != popA[j]) {
        stack.push(pushA[i++]);
      } else {
        i += 1;
        j += 1;
        while (!stack.isEmpty() && stack.peek() == popA[j]) {
          stack.pop();
          j += 1;
        }
      }
    }

    return stack.isEmpty();
  }

  public static void main(String[] args) {
    int[] push = new int[] {1, 2, 3, 4, 5};
    System.out.println(IsPopOrder(push, new int[] {4, 3, 5, 2, 1}));
    System.out.println(IsPopOrder(push, new int[] {4, 3, 5, 1, 2}));
  }

}
