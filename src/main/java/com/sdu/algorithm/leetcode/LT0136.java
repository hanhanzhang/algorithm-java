package com.sdu.algorithm.leetcode;

public class LT0136 {

    private static int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            res ^= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[] {2, 2, 1}));
    }

}
