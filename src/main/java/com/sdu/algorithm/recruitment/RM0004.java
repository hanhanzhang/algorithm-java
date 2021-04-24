package com.sdu.algorithm.recruitment;

public class RM0004 {

  private static String sum(String number1, String number2) {
    if (number1 == null || number1.isEmpty()) {
      return number2;
    }
    if (number2 == null || number2.isEmpty()) {
      return number1;
    }

    StringBuilder sb = new StringBuilder();
    int len = Math.min(number1.length(), number2.length());
    // 进位
    int carry = 0;
    for (int i = 1; i <= len; ++i) {
      int c1 = number1.charAt(number1.length() - i) - '0';
      int c2 = number2.charAt(number2.length() - i) - '0';
      int ret = c1 + c2 + carry;
      carry = ret / 10;
      sb.append(ret % 10);
    }

    String remain = number1.length() > number2.length() ? number1 : number2;
    len = Math.max(number1.length(), number2.length()) - len;
    for (int i = len - 1; i >= 0; --i) {
      int c1 = remain.charAt(i) - '0';
      int ret = c1 + carry;
      sb.append(ret % 10);
      carry = ret / 10;
    }

    if (carry != 0) {
      sb.append(carry);
    }

    return sb.reverse().toString();
  }

  public static void main(String[] args) {
    System.out.println(sum("155", "55"));
    System.out.println(sum("55", "55"));
  }

}
