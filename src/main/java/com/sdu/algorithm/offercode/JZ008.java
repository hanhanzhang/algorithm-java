package com.sdu.algorithm.offercode;

public class JZ008 {

  private static int JumpFloor(int target) {
    if (target == 1) {
      return 1;
    }
    if (target == 2) {
      return 2;
    }
    // dp[i] = dp[i - 1] + dp[i - 2]
    int[] dp = new int[target];
    dp[0] = 1;
    dp[1] = 2;
    for (int i = 2; i < target; ++i) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[target - 1];
  }

  public static void main(String[] args) {
    System.out.println(JumpFloor(3));
  }

}
