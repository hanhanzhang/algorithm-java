package com.sdu.algorithm.offercode;

import java.util.Arrays;

public class JZ032 {

  private static String PrintMinNumber(int [] numbers) {
    if (numbers == null || numbers.length == 0) {
      return "";
    }

    String[] nums = new String[numbers.length];
    for(int i = 0; i < numbers.length; i++){
      nums[i] = String.valueOf(numbers[i]);
    }

    Arrays.sort(nums, (s1, s2) -> {
      String c1 = s1 + s2;
      String c2 = s2 + s1;
      return c1.compareTo(c2);
    });

    StringBuilder sb = new StringBuilder();
    for (String num : nums) {
      sb.append(num);
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(PrintMinNumber(new int[] {32, 321, 3}));
    System.out.println("*******");
    System.out.println(PrintMinNumber(new int[] {32, 321, 32}));
  }

}
