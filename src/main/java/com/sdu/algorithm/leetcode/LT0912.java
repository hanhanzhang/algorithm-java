package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.ArrayUtils;

public class LT0912 {

    private static void quickSort(int[] nums, int st, int et) {
        if (st < 0 || st >= nums.length ||  st >= et) return;
        int target = nums[st];
        int low = st, high = et;
        while (low < high) {
            // 找第一个大于target的元素
            while (low < high && nums[low] <= target) {
                low += 1;
            }
            // 找第一个小于target的元素
            while (high > low && nums[high] >= target) {
                high -= 1;
            }
            if (low != high) {
                int tmp = nums[low];
                nums[low] = nums[high];
                nums[high] = tmp;
            }
        }
        if (target >= nums[low]) {
            // 移动元素
            for (int i = st + 1; i <= low; ++i) {
                nums[i - 1] = nums[i];
            }
            nums[low] = target;
            quickSort(nums, st, low - 1);
            quickSort(nums, low + 1, et);
        } else {
            // 移动元素
            for (int i = st + 1; i < low; ++i) {
                nums[i - 1] = nums[i];
            }
            nums[low - 1] = target;
            quickSort(nums, st, low - 2);
            quickSort(nums, low, et);
        }
    }

    // 快排
    private static int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void main(String[] args) {
        ArrayUtils.printArray(sortArray(new int[] {5, 2, 3, 1}));
        ArrayUtils.printArray(sortArray(new int[] {5, 1, 1, 2, 0, 0}));
        ArrayUtils.printArray(sortArray(new int[] {1, 0, 0, 2, 0}));
    }

}
