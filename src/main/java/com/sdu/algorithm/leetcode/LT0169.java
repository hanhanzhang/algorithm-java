package com.sdu.algorithm.leetcode;

public class LT0169 {

    private static int majorityElement(int[] nums) {
        // 摩尔投票, 元素不同则低效
        // count: 计数当前元素个数
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += num == candidate ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[] {3, 2, 3}));
        System.out.println(majorityElement(new int[] {2, 2, 1, 1, 1, 2, 2}));
        System.out.println(majorityElement(new int[] {3, 3, 4}));
    }

}
