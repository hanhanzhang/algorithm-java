package com.sdu.algorithm.offercode;

import java.util.Collections;
import java.util.List;

public class JZ064 {

  private static List<Integer> maxInWindows(int[] nums, int size) {
    if (nums == null || nums.length == 0) {
      return Collections.emptyList();
    }



    return null;
  }

  public static void main(String[] args) {
    List<Integer> ans = maxInWindows(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3);
    for (int num : ans) {
      System.out.println(num);
    }
  }

}
