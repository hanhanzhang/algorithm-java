package com.sdu.algorithm.offercode;

import java.util.PriorityQueue;
import java.util.Queue;

public class OR045 {

    private static String minNumber(int[] nums) {
        Queue<String> queue = new PriorityQueue<>((o1, o2) -> {
            String n1 = o1 + o2;
            String n2 = o2 + o1;
            return n1.compareTo(n2);
        });
        for (int num : nums) queue.offer("" + num);
        StringBuilder res = new StringBuilder();
        while (!queue.isEmpty()) {
            res.append(queue.poll());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(minNumber(new int[] {10, 2}));
        System.out.println(minNumber(new int[] {3, 30, 34, 5, 9}));
    }

}
