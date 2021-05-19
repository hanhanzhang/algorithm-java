package com.sdu.algorithm.leetcode;

public class LT0007 {

    private static int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int ret = x % 10;
            if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE  / 10) {
                return 0;
            }
            res = res * 10 + ret;
            x = x / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
    }

}
