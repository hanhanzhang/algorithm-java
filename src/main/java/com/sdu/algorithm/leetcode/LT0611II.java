package com.sdu.algorithm.leetcode;

import java.util.Arrays;

public class LT0611II {

    private static int triangleNumber(int[] nums) {
        // 数组排序, a <= b <= c, 故 a + c > b 和 b + c > a 一定成立, 只需判断 a + b >= c 且 a 或 b 不可为 0
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; ++i) {
            int k = i + 2;
            for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; ++j) {
                while (k < nums.length && nums[i] + nums[j] > nums[k])
                    k++;
                ans += k - j - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(triangleNumber(new int[] {2, 2, 3, 4}));
        System.out.println(triangleNumber(new int[] {2, 1, 1}));
    }

}
