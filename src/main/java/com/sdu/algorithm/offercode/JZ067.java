package com.sdu.algorithm.offercode;

public class JZ067 {

  private static int dfs(int target, int[] memo) {
    if (memo[target] != 0) {
      return memo[target];
    }
    int max = target;
    for (int i = 2; i < target; ++i) {
      int val = dfs(i, memo) * dfs(target - i, memo);
      if (val > max) {
        max = val;
      }
    }
    memo[target] = max;
    return memo[target];
  }

  private static int cutRope(int target) {
    if (target < 2) {
      return 0;
    }
    if (target == 2) {
      return 1;
    }
    if (target == 3) {
      return 2;
    }
    int[] memo = new int[target + 1];
    memo[0] = 0;
    memo[1] = 1;
    memo[2] = 2;
    memo[3] = 3;
    // 记忆化搜索
    return dfs(target, memo);
  }

  public static void main(String[] args) {
    System.out.println(cutRope(3));
    System.out.println(cutRope(5));
    System.out.println(cutRope(8));
  }

}
