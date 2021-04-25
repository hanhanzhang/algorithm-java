package com.sdu.algorithm.leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LT0264 {

    private static int nthUglyNumber(int n) {
        int[] factors = new int[] {2, 3, 5};
        Set<Long> visited = new HashSet<>();
        PriorityQueue<Long> queue = new PriorityQueue<>();
        visited.add(1L);
        queue.offer(1L);
        int ugly = 0;
        for (int i = 1; i <= n; ++i) {
            long cur = queue.poll();
            ugly = (int) cur;
            for (int factor : factors) {
                long next = cur * factor;
                if (visited.add(next)) {
                    queue.offer(next);
                }
            }
        }
        return ugly;
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(4));
        System.out.println(nthUglyNumber(10));
    }

}
