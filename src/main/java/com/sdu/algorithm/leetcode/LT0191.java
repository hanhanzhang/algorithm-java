package com.sdu.algorithm.leetcode;

public class LT0191 {

    private static int hammingWeight(int n) {
        int res = 0;
        for (int i = 1; i <= 32; ++i) {
            if ((n & (1 << i)) != 0) {
                res += 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(10));
        System.out.println(hammingWeight(15));
    }

}
