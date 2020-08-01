package com.sdu.algorithm.offercode;

import java.util.Stack;

public class JZ020 {

  private static final Stack<Integer> stack = new Stack<>();
  private static final Stack<Integer> minStack = new Stack<>();
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

  public static void main(String[] args) {
    push(1);
    push(2);
    push(1);
    System.out.println(min());
  }

}
