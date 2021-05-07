package com.sdu.algorithm.leetcode;

public class LT0134 {

    private static boolean dfs(int start, int next, int remain, int[] gas, int[] cost) {
        int pos = next % gas.length;
        // 判断是否可到达下个加油站
        int cur = (next - 1) % gas.length;
        if (remain < cost[cur]) return false;
        // 回到原点
        if (start == pos) return true;
        return dfs(start, next + 1, remain + gas[pos] - cost[cur], gas, cost);
    }

    private static int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; ++i) {
            boolean res = dfs(i, i + 1, gas[i], gas, cost);
            if (res) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[] {1, 2, 3, 4, 5}, new int[] {3, 4, 5, 1, 2}));
        System.out.println(canCompleteCircuit(new int[] {2, 3, 4}, new int[] {3, 4, 3}));
    }

}
