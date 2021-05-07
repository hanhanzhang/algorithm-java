package com.sdu.algorithm.leetcode;

public class LT0009 {

    private static boolean isPalindrome(int x) {
        if (x < 0) return false;
        int origin = x, res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return origin == res;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(122));
        System.out.println(isPalindrome(10));
    }

}

