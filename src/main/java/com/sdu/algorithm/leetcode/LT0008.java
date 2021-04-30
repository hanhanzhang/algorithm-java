package com.sdu.algorithm.leetcode;

public class LT0008 {

    private static int myAtoi(String s) {
        if (s == null || s.isEmpty()) return 0;

        // STEP1: 跳过空格
        int pos = 0;
        while (pos < s.length() && s.charAt(pos) == ' ') {
            pos += 1;
        }
        if (pos == s.length()) return 0;

        // STEP2: 确定元素符号
        int sign = 1;
        char ch = s.charAt(pos);
        if (ch == '-' || ch == '+') {
            pos += 1;
            sign = ch == '-' ? -1 : 1;
        }

        // STEP3: 计算和
        int ans = 0;
        char cur;
        while (pos < s.length() && Character.isDigit((cur = s.charAt(pos)))) {
            // 乘 10 前判断是否越界
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && (cur - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && (cur - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }
            ans = ans * 10 + sign * (cur - '0');
            pos += 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("2147483646"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
    }

}
