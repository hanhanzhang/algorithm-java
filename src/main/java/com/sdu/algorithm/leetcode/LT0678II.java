package com.sdu.algorithm.leetcode;

public class LT0678II {

    private static boolean checkValidString(String s) {
        // 记录左括号的最少和最多
        int min = 0, max = 0;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == '(') {
                min += 1;
                max += 1;
            } else if (ch == ')') {
               if (min > 0) min -= 1;
               if (--max < 0) return false;
            } else if (ch == '*') {
                if (min > 0) min -= 1;
                max += 1;
            }
        }
        return min == 0;
    }

    public static void main(String[] args) {
        System.out.println(checkValidString("()"));
        System.out.println(checkValidString("(*)"));
        System.out.println(checkValidString("(*)))"));
        System.out.println(checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));
        System.out.println(checkValidString("************************************************************"));
    }

}
