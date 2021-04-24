package com.sdu.algorithm.leetcode;

public class LT0718 {

    private static int findLength(int[] nums1, int[] nums2) {
        int maxLen = 0;
        int[][] matrix = new int[nums1.length][nums2.length];
        for (int i = 0; i < nums1.length; ++i) {
            for (int k = 0; k < nums2.length; ++k) {
                if (nums1[i] == nums2[k]) {
                    if (i == 0 || k == 0) {
                        matrix[i][k] = 1;
                    } else {
                        matrix[i][k] = matrix[i - 1][k - 1] + 1;
                    }
                    maxLen = Math.max(maxLen, matrix[i][k]);
                } else {
                    matrix[i][k] = 0;
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {1, 2, 3, 2, 1};
        int[] nums2 = new int[] {3, 2, 1, 4, 7};
        System.out.println(findLength(nums1, nums2));

        int[] nums3 = new int[] {0, 1, 1, 1, 1};
        int[] nums4 = new int[] {1, 0, 1, 0, 1};
        System.out.println(findLength(nums3, nums4));
    }

}
