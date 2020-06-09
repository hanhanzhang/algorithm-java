package com.sdu.algorithm.leetcode;

public class LT739 {

  private static int[] dailyTemperatures(int[] T) {
    if (T == null || T.length == 0) {
      return T;
    }
    int[] ans = new int[T.length];

    // dp[i]表示比第i个元素大位置
    int[] dp = new int[T.length];
    int len = T.length - 1;
    dp[len] = -1;
    ans[len] = 0;

    for (int i = len - 1; i >= 0; i--) {
      if (T[i] < T[i + 1]) {
        ans[i] = 1;
        dp[i] = i + 1;
        continue;
      }
      // 向后找
      int pos = dp[i + 1];
      boolean occur = false;
      while (pos != -1) {
        if (T[i] < T[pos]) {
          ans[i] = pos - i;
          dp[i] = pos;
          occur = true;
          break;
        }
        pos = dp[pos];
      }

      if (!occur) {
        ans[i] = 0;
        dp[i] = -1;
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    int[] ans = dailyTemperatures(new int[] {73, 74, 75, 71, 69, 72, 76, 73});
    for (int a : ans) {
      System.out.println(a);
    }
  }

}
