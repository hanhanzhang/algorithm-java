package com.sdu.algorithm.leetcode;

public class LT0033 {

    private static int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return -1;
        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[lo] <= nums[mid]) { // 有序
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[] {4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(search(new int[] {4, 5, 6, 7, 0, 1, 2}, 8));
    }

}
