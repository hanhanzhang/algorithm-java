package com.sdu.algorithm.offercode;

public class JZ008 {

  private static int JumpFloor(int target) {
    if (target <= 0) {
      return 0;
    }
    if (target == 1) {
      return 1;
    }
    if (target == 2) {
      return 2;
    }
    // dp[i] = dp[i - 1] + dp[i - 2]
    // 只需要前两次跳动记录, a: 表示跳两个台阶, b: 表示跳一个台阶
    int a = 1, b = 2;
    for (int i = 3; i <= target; ++i) {
      int temp = a + b;
      a = b;
      b = temp;
    }
    return b;
  }

  public static void main(String[] args) {
    System.out.println(JumpFloor(3));
  }

}
