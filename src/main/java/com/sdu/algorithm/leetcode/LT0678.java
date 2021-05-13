package com.sdu.algorithm.leetcode;

public class LT0678 {

    // DFS提交超时
    private static boolean dfs(String s, int start, int cnt) {
        if (cnt < 0) return false;
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                cnt += 1;
            } else if (c == ')') {
                cnt -= 1;
                if (cnt < 0) return false;
            } else if (c == '*') {
                return dfs(s, i + 1, cnt + 1) ||
                        dfs(s, i + 1, cnt - 1) ||
                        dfs(s, i + 1, cnt);
            }
        }
        return cnt == 0;
    }

    private static boolean checkValidString(String s) {
        return dfs(s, 0, 0);
    }

    public static void main(String[] args) {
        System.out.println(checkValidString("()"));
        System.out.println(checkValidString("(*)"));
        System.out.println(checkValidString("(*)))"));
        System.out.println(checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));
//        System.out.println(checkValidString("************************************************************"));
    }

}
