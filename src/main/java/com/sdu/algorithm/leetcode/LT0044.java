package com.sdu.algorithm.leetcode;

public class LT0044 {

    private static boolean isMatch(String s, String p, int sp, int mp) {
        if (sp == -1 && mp == -1) return true;
        if (sp == -1 && mp != -1) {
            for (int i = 0; i <= mp; ++i) {
                if (p.charAt(i) != '*') {
                    return false;
                }
            }
            return true;
        }
        if (mp == -1) {
            return false;
        }
        char ch1 = s.charAt(sp), ch2 = p.charAt(mp);
        if (ch1 == ch2 || ch2 == '?') {
            return isMatch(s, p, sp - 1, mp - 1);
        }
        if (ch2 == '*') {
            // 匹配空串或多次
            return isMatch(s, p, sp, mp - 1) || isMatch(s, p, sp - 1, mp);
        }
        return false;
    }

    private static boolean isMatch(String s, String p) {
        // 搜索匹配, 超时
        int sp = (s == null || s.isEmpty()) ? -1 : s.length() - 1;
        int mp = (p == null || p.isEmpty()) ? -1 : p.length() - 1;
        return isMatch(s, p, sp, mp);
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "********"));
        System.out.println(isMatch("cb", "?a"));
        System.out.println(isMatch("adceb", "*a*b"));
    }

}
