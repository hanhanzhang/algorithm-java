package com.sdu.algorithm.leetcode;

public class LT0283 {

  private static void moveZeroes(int[] nums) {
    if (nums == null || nums.length == 0) {
      return;
    }

    int zero = 0, noneZero = 0;
    while (noneZero < nums.length) {
      while (noneZero < nums.length && nums[noneZero] == 0) {
        noneZero += 1;
      }
      if (noneZero >= nums.length) {
        break;
      }
      while (zero <= noneZero && nums[zero] != 0) {
        zero += 1;
      }

      if (noneZero > zero) {
        nums[zero] = nums[noneZero];
        nums[noneZero] = 0;
      } else {
        noneZero += 1;
      }
    }
  }

  public static void main(String[] args) {
    int[] nums = new int[] {0, 1, 0, 3, 12};
    moveZeroes(nums);
    for (int num : nums) {
      System.out.println(num);
    }
    System.out.println("********");

    int[] nums1 = new int[] {1};
    moveZeroes(nums1);
    for (int num : nums1) {
      System.out.println(num);
    }
  }

}
