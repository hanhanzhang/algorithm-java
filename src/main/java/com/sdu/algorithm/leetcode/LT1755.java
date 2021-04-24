package com.sdu.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LT1755 {

    public static int minAbsDifference(int[] nums, int goal) {
        // dpSums[i]: 表示以i结尾所有子序列的和
        List<Integer>[] dpSums = new List[nums.length];
        int nearSum = 0;
        for (int i = 0; i < nums.length; ++i) {
            dpSums[i] = new ArrayList<>();
            dpSums[i].add(nums[i]);
            if (i - 1 >= 0) {
                for (int sum : dpSums[i - 1]) {
                    dpSums[i].add(sum);
                    dpSums[i].add(sum + nums[i]);
                }
            }

            for (int sum : dpSums[i]) {
                if (Math.abs(sum - goal) <= Math.abs(nearSum - goal)) {
                    nearSum = sum;
                }
            }
        }

        return Math.abs(nearSum - goal);
    }

    public static void main(String[] args) {
        System.out.println(minAbsDifference(new int[] {5, -7, 3, 5}, 6));
        System.out.println(minAbsDifference(new int[] {7, -9, 15, -2}, -5));
        System.out.println(minAbsDifference(new int[] {1, 2, 3}, -7));
    }

}
