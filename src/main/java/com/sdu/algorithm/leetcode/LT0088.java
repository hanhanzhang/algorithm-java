package com.sdu.algorithm.leetcode;

public class LT0088 {

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        // 双指针: 从后向前遍历可避免元素移动
        int tail = m + n - 1, i = m - 1, k = n - 1;
        for (; i >= 0 || k >= 0; ) {
            if (k < 0) break;
            if (i < 0) {
                nums1[tail--] = nums2[k--];
            } else if (nums1[i] >= nums2[k]) {
                nums1[tail--] = nums1[i--];
            } else {
                nums1[tail--] = nums2[k--];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {1, 2, 3, 0, 0, 0}, nums2 = new int[] {2, 5, 6};
        merge(nums1, 3, nums2, 3);
        for (int num : nums1) {
            System.out.println(num);
        }

        System.out.println("###############");

        int[] nums3 = new int[] {0, 0, 3, 0, 0, 0, 0, 0, 0};
        int[] nums4 = new int[] {-1, 1, 1, 1, 2, 3};
        merge(nums3, 3, nums4, 6);
        for (int num : nums3) {
            System.out.println(num);
        }
    }

}
