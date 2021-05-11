package com.sdu.algorithm.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class LT0179 {

    private static String largestNumber(int[] nums) {
        Queue<String> queue = new PriorityQueue<>((o1, o2) -> {
           String n1 = o1 + o2;
           String n2 = o2 + o1;
           return n2.compareTo(n1);
        });
        for (int num : nums) queue.offer("" + num);
        StringBuilder sb = new StringBuilder();
        boolean add = false;
        while (!queue.isEmpty()) {
            String num = queue.poll();
            if (!num.equals("0") || add) {
                sb.append(num);
                add = true;
            }
        }
        return add ? sb.toString() : "0";
    }

    public static void main(String[] args) {
        System.out.println(largestNumber(new int[] {10, 2}));
        System.out.println(largestNumber(new int[] {3, 30, 34, 5, 9}));
        System.out.println(largestNumber(new int[] {0, 0}));
        System.out.println(largestNumber(new int[] {0, 0, 0}));
    }

}
