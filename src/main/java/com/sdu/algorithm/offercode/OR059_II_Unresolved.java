package com.sdu.algorithm.offercode;

import java.util.ArrayDeque;
import java.util.Queue;

public class OR059_II_Unresolved {

    public static class MaxQueue {

        private Queue<Integer> queue;
        private Queue<Integer> maxQueue;

        public MaxQueue() {
            queue = new ArrayDeque<>();
            maxQueue = new ArrayDeque<>();
        }

        public int max_value() {
            return maxQueue.isEmpty() ? -1 : maxQueue.peek();
        }

        public void push_back(int value) {
            queue.offer(value);
            while (!maxQueue.isEmpty() && maxQueue.peek() < value) {
                maxQueue.poll();
            }
            maxQueue.offer(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) {
                return -1;
            }
            int ans = queue.poll();
            if (ans == max_value()) {
                maxQueue.poll();
            }
            return ans;
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
