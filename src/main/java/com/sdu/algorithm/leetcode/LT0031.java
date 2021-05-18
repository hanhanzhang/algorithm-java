package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.ArrayUtils;

public class LT0031 {

  private static void swap(int[] nums, int i, int j) {
    int res = nums[i];
    nums[i] = nums[j];
    nums[j] = res;
  }

  private static void reverse(int[] nums, int start) {
    int l = start, r = nums.length - 1;
    while (l < r) {
      swap(nums, l, r);
      l += 1;
      r -= 1;
    }
  }

  private static void nextPermutation(int[] nums) {
    // 尽可能在最右侧的逆序对
    int i = nums.length - 2;
    while (i >= 0 && nums[i] >= nums[i + 1]) {
      i--;
    }
    if (i >= 0) {
      int j = nums.length - 1;
      while (j >= 0 && nums[i] >= nums[j]) {
        j--;
      }
      swap(nums, i, j);
    }
    reverse(nums, i + 1);
  }

  public static void main(String[] args) {
    int[] array1 = new int[] {3, 1, 2};
    nextPermutation(array1);
    ArrayUtils.printArray(array1);

    int[] array2 = new int[] {1, 2, 3};
    nextPermutation(array2);
    ArrayUtils.printArray(array2);

    int[] array3 = new int[] {3, 2, 1};
    nextPermutation(array3);
    ArrayUtils.printArray(array3);

    int[] array4 = new int[] {1, 3, 2};
    nextPermutation(array4);
    ArrayUtils.printArray(array4);

    int[] array5 = new int[] {1, 5, 1};
    nextPermutation(array5);
    ArrayUtils.printArray(array5);

    int[] array6 = new int[] {5, 4, 7, 5, 3, 2};
    nextPermutation(array6);
    ArrayUtils.printArray(array6);
  }

}
