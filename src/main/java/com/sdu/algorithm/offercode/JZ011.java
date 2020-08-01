package com.sdu.algorithm.offercode;

public class JZ011 {

  private static int NumberOf1(int n) {
    int mark = 1;
    int ans = 0;
    // 左移: 低位补零
    // 右移: 正数补零, 负数补1
    while (mark != 0) {
      if ((mark & n) == mark) {
        ans += 1;
      }
      mark = mark << 1;
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(Integer.toBinaryString(-1));
    System.out.println(Integer.toBinaryString(0));
    System.out.println(NumberOf1(-1));
    System.out.println(NumberOf1(15));
    System.out.println(NumberOf1(16));
  }

}
