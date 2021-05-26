package com.sdu.algorithm.leetcode;

public class LT0067 {

  private static String addBinary(String a, String b) {
    int len = a.length() + b.length();
    char[] sum = new char[len];
    int carry = 0, p1 = a.length() - 1, p2 = b.length() - 1, pos = len - 1;
    while (carry > 0 || p1 >= 0 || p2 >= 0) {
      int ch1 = p1 >= 0 ? a.charAt(p1--) - '0' : 0;
      int ch2 = p2 >= 0 ? b.charAt(p2--) - '0' : 0;
      int res = ch1 + ch2 + carry;
      carry = res / 2;
      sum[pos--] = (char) ((res % 2) + '0');
    }
    return new String(sum, pos + 1, len - pos - 1);
  }

  public static void main(String[] args) {
    System.out.println(addBinary("11", "1"));
    System.out.println(addBinary("1010", "1011"));
  }

}
