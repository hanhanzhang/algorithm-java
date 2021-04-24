package com.sdu.algorithm.leetcode;

public class LT0060 {

    private static String ans = null;
    private static int cnt = 0;


    private static void permutation(int n, boolean[] visited, StringBuilder nums,  int k) {
        if (nums.length() == n) {
            if (++cnt == k) {
                ans = nums.toString();
            }
            return;
        }
        for (int i = 1; i <= n; ++i) {
            if (visited[i - 1]) continue;
            StringBuilder ret = new StringBuilder(nums);
            ret.append(i);
            visited[i - 1] = true;
            permutation(n, visited, ret, k);
            visited[i - 1] = false;
            if (ans != null) break;
        }
    }

    private static String getPermutation(int n, int k) {
        permutation(n, new boolean[n], new StringBuilder(), k);
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(getPermutation(3, 3));
        System.out.println(getPermutation(4, 9));
    }

}
