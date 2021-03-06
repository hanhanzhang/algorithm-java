package com.sdu.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LT0001 {

  private static int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement) && map.get(complement) != i) {
        return new int[] { i, map.get(complement) };
      }
    }
    throw new IllegalArgumentException("No two sum solution");
  }

  public static void main(String[] args) {
    int target = 9;
    int[] index = twoSum(new int[] {2, 7, 11, 15}, target);
    System.out.println("position: [" + index[0] + ", " + index[1] + "]");
  }

}
