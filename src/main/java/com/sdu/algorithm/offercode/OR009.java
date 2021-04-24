package com.sdu.algorithm.offercode;

import java.util.Stack;

public class OR009 {

    public static class CQueue {

        // 进栈顺序
        private Stack<Integer> stack1;
        // 出栈顺序
        private Stack<Integer> stack2;

        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.isEmpty() ? -1 : stack2.pop();
        }

    }

    public static void main(String[] args) {
        CQueue queue = new CQueue();
        queue.appendTail(1);
        queue.appendTail(2);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        queue.appendTail(5);
        System.out.println(queue.deleteHead());
        queue.appendTail(6);
        System.out.println(queue.deleteHead());
    }

}
