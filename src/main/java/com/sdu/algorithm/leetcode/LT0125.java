package com.sdu.algorithm.leetcode;

public class LT0125 {

    private static boolean isPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        while (low < high) {
            while (low < high && !Character.isLetterOrDigit(s.charAt(low))) low +=1;
            while (low < high && !Character.isLetterOrDigit(s.charAt(high))) high -= 1;
            if (low < high) {
                if (Character.toLowerCase(s.charAt(low)) != Character.toLowerCase(s.charAt(high))) {
                    return false;
                }
                low += 1;
                high -= 1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
    }

}
