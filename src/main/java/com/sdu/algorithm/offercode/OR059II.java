package com.sdu.algorithm.offercode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class OR059II {

    public static class MaxQueue {

        private Queue<Integer> queue;
        private Deque<Integer> maxQueue;


        public MaxQueue() {
            queue = new ArrayDeque<>();
            maxQueue = new ArrayDeque<>();
        }

        public int max_value() {
            return maxQueue.isEmpty() ? -1 : maxQueue.peek();
        }

        public void push_back(int value) {
            queue.offer(value);
            // maxQueue移除比当前value小的元素
            while (!maxQueue.isEmpty() && maxQueue.peekLast() < value) {
                maxQueue.pollLast();
            }
            maxQueue.offerLast(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) return -1;
            int value = queue.poll();
            if (value == maxQueue.peekFirst()) maxQueue.pollFirst();
            return value;
        }
    }

    public static void main(String[] args) {
        MaxQueue queue = new MaxQueue();
        queue.push_back(3);
        queue.push_back(2);
        queue.push_back(1);
        System.out.println(queue.pop_front());
        System.out.println(queue.max_value());
    }

}
