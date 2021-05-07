package com.sdu.algorithm.leetcode;

import java.util.Stack;

public class LT0155 {

    static class MinStack {

        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);
            if (minStack.isEmpty()) {
                minStack.push(val);
            } else {
                int min = minStack.peek();
                minStack.push(Math.min(min, val));
            }
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(6);
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(2);
        System.out.println(minStack.getMin());
    }

}
