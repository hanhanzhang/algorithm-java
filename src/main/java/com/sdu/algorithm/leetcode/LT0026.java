package com.sdu.algorithm.leetcode;

public class LT0026 {

    private static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int fast = 1, slow = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[] {1, 1, 2}));
        System.out.println(removeDuplicates(new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

}
