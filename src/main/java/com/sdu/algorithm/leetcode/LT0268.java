package com.sdu.algorithm.leetcode;

public class LT0268 {

    private static int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[] {9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }

}
