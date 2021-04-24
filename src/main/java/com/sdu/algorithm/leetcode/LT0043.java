package com.sdu.algorithm.leetcode;

public class LT0043 {

  private static String multiply(String num1, String num2) {
    if (num1.equals("0") || num2.equals("0")) {
      return "0";
    }
    // 结果长度最大为: num1.length() + num2.length()
    int[] ans = new int[num1.length() + num2.length()];
    int pos = ans.length - 1;

    for (int i = num2.length() - 1; i >= 0; --i){
      int n1 = num2.charAt(i) - '0';
      int k = num1.length() - 1, carry = 0;
      int start = pos;
      while (k >= 0 || carry > 0) {
        int n2 = k >= 0 ? num1.charAt(k--) - '0' : 0;
        int sum = n2 * n1 + carry + ans[start];
        ans[start--] = sum % 10;
        carry = sum / 10;
      }
      pos -= 1;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < ans.length; ++i) {
      if (i == 0 && ans[i] == 0) {
        continue;
      }
      sb.append(ans[i]);
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(multiply("123", "456"));
    System.out.println(multiply("9", "99"));
    System.out.println(multiply("999", "999"));
  }

}
