package com.sdu.algorithm.offercode;

import java.util.Comparator;
import java.util.PriorityQueue;

import static com.sdu.algorithm.utils.ArrayUtils.printArray;

public class OR040 {

    private static int[] getLeastNumbers(int[] arr, int k) {

        class IntComparator implements Comparator<Integer> {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(new IntComparator());
        for (int i = 0; i < arr.length; ++i) {
            if (queue.size() < k) {
                queue.add(arr[i]);
            } else {
                queue.add(arr[i]);
                queue.poll();
            }
        }
        return queue.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        printArray(getLeastNumbers(new int[]{3, 2, 1}, 2));
        printArray(getLeastNumbers(new int[]{0, 1, 2, 1}, 1));
    }

}
