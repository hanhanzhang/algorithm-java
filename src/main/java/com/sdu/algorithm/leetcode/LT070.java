package com.sdu.algorithm.leetcode;

/**
 * 假设你正在爬楼梯, 需要 n 阶你才能到达楼顶
 *
 * 每次你可以爬 1 或 2 个台阶, 你有多少种不同的方法可以爬到楼顶呢
 *
 * 注意: 给定 n 是一个正整数
 *
 * 示例 1:
 *
 * 输入： 2
 * 输出： 2
 * */
public class LT070 {

  // 递归方式
  private static int climbStairs(int n) {
    if (n == 1 || n == 2) {
      return n;
    }
    return climbStairs(n - 2) + climbStairs(n - 1);
  }

  // 非递归方式
  private static int climbStairs0(int n) {
    if (n == 1 || n == 2) {
      return n;
    }

    int[] dp = new int[n];
    dp[0] = 1;
    dp[1] = 2;

    for (int i = 2; i < n; ++i) {
      dp[i] = dp[i - 2] + dp[i - 1];
    }

    return dp[n - 1];
  }

  // 非递归方式
  private static int climbStairs1(int n) {
    if (n == 1 || n == 2) {
      return n;
    }

    // 只需要记录前两个值即可
    int m = 1;
    int k = 2;

    int r = -1;

    for (int i = 2; i < n; ++i) {
      r = m + k;
      m = k;
      k = r;
    }

    return r;
  }

  public static void main(String[] args) {

    System.out.println(climbStairs1(3));

  }

}
