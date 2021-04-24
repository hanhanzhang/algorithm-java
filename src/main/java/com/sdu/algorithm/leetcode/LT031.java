package com.sdu.algorithm.leetcode;

public class LT031 {

  private static void nextPermutation(int[] nums) {
    if (nums == null || nums.length == 0) return;

    int max = nums[nums.length - 1];
    for (int i = nums.length - 2; i >= 0; --i) {
      if (nums[i] < max) {
        for (int k = i + 1; k < nums.length; ++k) {
          if (nums[k] > nums[i]) {
            int temp = nums[i];
            nums[i] = nums[k];
            nums[k] = temp;
            return;
          }
        }
      } else {
        max = nums[i];
        // 排序, 升序
        int k = i + 1;
        for (; k < nums.length; ++k) {
          nums[k - 1] = nums[k];
        }
        nums[k - 1] = max;
      }
    }
  }

  public static void main(String[] args) {
    int[] nums = new int[] {3, 1, 2};
    nextPermutation(nums);
    for (int num : nums) {
      System.out.println(num);
    }
    System.out.println();

    int[] nums0 = new int[] {1, 2, 3};
    nextPermutation(nums0);
    for (int num : nums0) {
      System.out.println(num);
    }
    System.out.println();

    int[] nums1 = new int[] {3, 2, 1};
    nextPermutation(nums1);
    for (int num : nums1) {
      System.out.println(num);
    }
    System.out.println();

    int[] nums2 = new int[] {1, 3, 2};
    nextPermutation(nums2);
    for (int num : nums2) {
      System.out.println(num);
    }
    System.out.println();

    int[] nums3 = new int[] {1, 5, 1};
    nextPermutation(nums3);
    for (int num : nums3) {
      System.out.println(num);
    }
    System.out.println();

    int[] nums4 = new int[] {5, 4, 7, 5, 3, 2};
    nextPermutation(nums4);
    for (int num : nums4) {
      System.out.println(num);
    }
  }

}
