package com.sdu.algorithm.leetcode;

public class LT0704 {

    private static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[] {-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(search(new int[] {-1, 0, 3, 5, 9, 12}, 2));
    }

}
