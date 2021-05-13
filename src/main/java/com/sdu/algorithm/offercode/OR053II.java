package com.sdu.algorithm.offercode;

public class OR053II {

    // 在排序数组中查找数字出现次数
    private static int search(int[] nums, int target) {
        // TODO: 折半查找
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int low = 0, high = nums.length - 1;
        if (nums[low] > target || nums[high] < target) {
            return 0;
        }
        while (low <= high && (nums[low] != target || nums[high] != target)) {
            if (nums[low] < target) {
                low += 1;
            }
            if (nums[high] > target) {
                high -= 1;
            }
        }
        return low > high ? 0 : high - low + 1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{5, 7, 7, 8, 8, 10}, 8));
        System.out.println(search(new int[]{5, 7, 7, 8, 8, 10}, 6));
    }

}
