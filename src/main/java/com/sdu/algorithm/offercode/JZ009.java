package com.sdu.algorithm.offercode;

public class JZ009 {

  private static int JumpFloorII(int target) {
    // f(n) = f(n - 1) + f(n - 2) + ... + f(1)
    // f(n - 1) = f(n - 2) + ... + f(1)
    // f(n) - f(n - 1) = f(n - 1) => f(n) = 2 * f(n - 1)
    return 1 << (target - 1);
  }

  public static void main(String[] args) {
    System.out.println(JumpFloorII(1));
    System.out.println(JumpFloorII(2));
    System.out.println(JumpFloorII(3));
  }

}
