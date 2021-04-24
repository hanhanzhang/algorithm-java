package com.sdu.algorithm.leetcode;

public class LT287 {

  private static int findDuplicate(int[] nums) {
    // 重复元素可有多个, 故不可用异或运算
    int left = 1, right = nums.length - 1;
    while (left < right) {
      int mid = (left + right) / 2;

      int cnt = 0;
      for (int num : nums) {
        cnt += num <= mid ? 1: 0;
      }

      if (cnt <= mid) {
        // 重复元素在[mid + 1, right]区间
        left = mid + 1;
      } else {
        // 重复元素在[1, mid]区间
        right = mid;
      }
    }
    return left;
  }



  public static void main(String[] args) {
    System.out.println(findDuplicate(new int[] {1, 2, 3, 2, 2}));
    System.out.println(findDuplicate(new int[] {1, 2, 3, 4, 2}));
    System.out.println(findDuplicate(new int[] {1, 2, 3, 4, 5, 3}));
  }

}
