package com.sdu.algorithm.offercode;

import java.util.Stack;

public class JZ020 {

  private static Stack<Integer> stack = new Stack<>();
  private static Stack<Integer> minStack = new Stack<>();
  private static int min = Integer.MAX_VALUE;

  private static void push(int node) {
    stack.push(node);
    if (node < min) {
      min = node;
    }
    minStack.push(min);
  }

  private static void pop() {
    stack.pop();
    minStack.pop();
  }

  private static int top() {
    return stack.peek();
  }

  private static int min() {
    return minStack.peek();
  }

}
