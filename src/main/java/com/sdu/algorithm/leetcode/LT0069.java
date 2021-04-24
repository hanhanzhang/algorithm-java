package com.sdu.algorithm.leetcode;

public class LT0069 {

    private static int mySqrt(int x) {
        // 注意: 越界
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(0));
        System.out.println(mySqrt(1));
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(16));
        System.out.println(mySqrt(Integer.MAX_VALUE));
    }

}
