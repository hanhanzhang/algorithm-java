package com.sdu.algorithm.string;

public class LT043 {

  private static String multiply(String num1, String num2) {
    if (num1.equals("0") || num2.equals("0")) {
      return "0";
    }
    int[] ans = new int[num1.length() + num2.length()];
    int m = 1;
    int pos = ans.length - m;

    for (int i = num2.length() - 1; i >= 0; --i) {
      int carry = 0;
      for (int k = num1.length() - 1; k >= 0; --k) {
        int n1 = (int) num2.charAt(i) - (int) '0';
        int n2 = (int) num1.charAt(k) - (int) '0';
        int res = n1 * n2;
        if (res >= 10) {
          carry = res / 10;
          res = res % 10;
        }

        ans[pos] += res;
        if (ans[pos] >= 10) {
          int temp = ans[pos];
          ans[pos] = temp % 10;
          carry += temp / 10;
        }

        ans[pos - 1] += carry;
        if (ans[pos - 1] >= 10) {
          int temp = ans[pos - 1];
          ans[pos - 1] = temp % 10;
          ans[pos - 2] += temp / 10;
        }

        pos -= 1;
        carry = 0;
      }

      m += 1;
      pos = ans.length - m;
    }
    StringBuilder sb = new StringBuilder();
    int start = 0;
    if (ans[0] == 0) {
      start = 1;
    }
    for (int i = start; i < ans.length; ++i) {
      sb.append(ans[i]);
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(multiply("123", "456"));
    System.out.println(multiply("9", "9"));
    System.out.println(multiply("999", "999"));
  }

}
