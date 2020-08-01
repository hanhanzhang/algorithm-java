package com.sdu.algorithm.offercode;

public class JZ043 {

  private static String LeftRotateString(String str, int n) {
    if (str == null || str.isEmpty() || n == 0) {
      return str;
    }
    n = n % str.length();
    return str.substring(n) + str.substring(0, n);
  }

  public static void main(String[] args) {
    System.out.println(LeftRotateString("abcXYZdef", 3));
    System.out.println("**********");
    System.out.println(LeftRotateString("abcXHZdef", 4));
  }

}
