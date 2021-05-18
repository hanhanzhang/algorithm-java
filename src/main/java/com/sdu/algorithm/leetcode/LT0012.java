package com.sdu.algorithm.leetcode;

public class LT0012 {

  private static String intToRoman(int num) {
    int[] values = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < values.length; ++i) {
      int value = values[i];
      while (num >= value) {
        res.append(symbols[i]);
        num -= value;
      }
    }
    return res.toString();
  }

  public static void main(String[] args) {
    System.out.println(intToRoman(58));
    System.out.println(intToRoman(1994));
  }
}
