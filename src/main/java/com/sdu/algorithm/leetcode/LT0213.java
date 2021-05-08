package com.sdu.algorithm.leetcode;

public class LT0213 {

    private static int rob(int[] nums, int start, int end) {
        int first = nums[start], second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }

    private static int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // 最后一间房偷或不偷
        return Math.max(rob(nums, 0, length - 2), rob(nums, 1, length - 1));
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[] {1, 2, 3, 1}));
    }

}
