package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.ListUtils;

import java.util.ArrayList;
import java.util.List;

public class LT0442 {

    private static List<Integer> findDuplicates(int[] nums) {
        // 负数标记出现过, 无需移动元素
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        for (int i = 0; i < nums.length; ++i) {
            int num = Math.abs(nums[i]);
            if (nums[num - 1] < 0) {
                res.add(num);
            } else {
                nums[num - 1] *= -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ListUtils.printList(findDuplicates(new int[] {4, 3, 2, 7, 8, 2, 3, 1}));
    }

}
