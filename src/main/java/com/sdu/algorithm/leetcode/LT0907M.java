package com.sdu.algorithm.leetcode;

import java.util.Stack;

public class LT0907M {

    private static int sumSubarrayMins(int[] arr) {
        // https://leetcode-cn.com/problems/sum-of-subarray-minimums/solution/dan-diao-zhan-zuo-you-liang-bian-di-yi-g-ww3n/
        // 暴力解法, 提交超时
        int MOD = 1_000_000_007;
        Stack<int[]> stack = new Stack<>();
        int ans = 0, dot = 0;
        for (int i = 0; i < arr.length; ++i) {
            int count = 1;
            //
            while (!stack.isEmpty() && stack.peek()[0] >= arr[i]) {
                // 更新最小值
                int[] mir = stack.pop();
                count += mir[1];
                dot -= mir[0] * mir[1];
            }
            stack.push(new int[] {arr[i], count});
            dot += arr[i] * count;
            ans += dot;
            ans %= MOD;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(sumSubarrayMins(new int[] {3, 1, 2, 4}));
        System.out.println(sumSubarrayMins(new int[] {11, 81, 94, 43, 3}));
    }

}
