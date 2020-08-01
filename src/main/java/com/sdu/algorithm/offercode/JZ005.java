package com.sdu.algorithm.offercode;

import java.util.Stack;

public class JZ005 {

  private static Stack<Integer> stack1 = new Stack<>();
  private static Stack<Integer> stack2 = new Stack<>();

  private static void push(int node) {
    // stack1: 进栈顺序
    // stack2: 出栈顺序
    stack1.push(node);
  }

  private static int pop() {
    if (stack2.isEmpty()) {
      while (!stack1.isEmpty()) {
        stack2.push(stack1.pop());
      }
    }
    return stack2.pop();
  }

  public static void main(String[] args) {
    push(1);
    push(2);
    push(3);
    push(4);
    System.out.println(pop());
    System.out.println(pop());
    push(5);
    System.out.println(pop());
    push(6);
    System.out.println(pop());
    System.out.println(pop());
    System.out.println(pop());
  }

}
