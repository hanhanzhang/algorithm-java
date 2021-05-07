package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.ArrayUtils;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LT0239 {

    private static int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        int[] res = new int[nums.length - k + 1];
        int cur = 0;
        for (int i = 0; i < res.length; ++i) {
            int index = -1;
            while (cur < nums.length) {
                queue.offer(new int[] {cur, nums[cur]});
                int leftIndex = cur - k + 1;
                cur += 1;
                if (leftIndex >= 0) {
                    int[] top = queue.peek();
                    assert top != null;
                    if (top[0] < leftIndex) {
                        while (top != null && top[0] < leftIndex) {
                            queue.poll();
                            top = queue.peek();
                        }
                    }
                    assert top != null;
                    index = top[0];
                    break;
                }
            }
            if (index != -1) res[i] = nums[index];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res1 = maxSlidingWindow(new int[] {1, 3, -1, -3, 5, 3, 6, 7}, 3);
        ArrayUtils.printArray(res1);

        int[] res2 = maxSlidingWindow(new int[] {9, 11}, 2);
        ArrayUtils.printArray(res2);
    }

}
