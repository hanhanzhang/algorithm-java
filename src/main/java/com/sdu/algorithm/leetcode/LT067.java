package com.sdu.algorithm.leetcode;

public class LT067 {

  private static String addBinary(String a, String b) {
    if (a.equals("0")) return b;
    if (b.equals("0")) return a;

    char[] sum = new char[Math.max(a.length(), b.length()) + 1];

    int index = 1;
    int carry = 0;
    while (a.length() - index >= 0 || b.length() - index >= 0) {
      int a1 = a.length() - index < 0 ? 0 : (int) a.charAt(a.length() - index) - (int) '0';
      int b1 = b.length() - index < 0 ? 0 : (int) b.charAt(b.length() - index) - (int) '0';

      int tmp = a1 + b1 + carry;

      sum[sum.length - index] = (char) (tmp % 2 + '0');
      carry = tmp / 2;
      index += 1;
    }

    if (carry == 1) {
      sum[0] = '1';
      return new String(sum);
    }

    return new String(sum, 1, sum.length - 1);
  }

  public static void main(String[] args) {
    System.out.println(addBinary("11", "1"));
  }

}
