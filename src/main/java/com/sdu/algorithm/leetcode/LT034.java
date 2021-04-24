package com.sdu.algorithm.leetcode;

public class LT034 {

  private static int[] searchRange(int[] nums, int from, int to, int target) {
    if (from < 0 || to > nums.length - 1 || from > to) {
      return new int[] {-1, -1};
    }
    int mid = (from + to) / 2;
    if (nums[mid] == target) {
      int[] left = searchRange(nums, from, mid - 1, target);
      int[] right = searchRange(nums, mid + 1, to, target);
      return new int[] {
          left[0] == -1 ? mid : left[0],
          right[1] == -1 ? mid : right[1]
      };
    }
    if (nums[mid] < target) {
      return searchRange(nums, mid + 1, to, target);
    }
    return searchRange(nums, from, mid - 1, target);
  }

  private static int[] searchRange(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return new int[] {-1, -1};
    }
    return searchRange(nums, 0, nums.length - 1, target);
  }

  public static void main(String[] args) {
    int[] nums = new int[] {5, 5, 5};
    int[] ans = searchRange(nums, 5);
    for (int n : ans) {
      System.out.println(n);
    }
    System.out.println();

    int[] nums1 = new int[] {5, 7, 7, 8, 8, 10};
    int[] ans1 = searchRange(nums1, 8);
    for (int n : ans1) {
      System.out.println(n);
    }
    System.out.println();

    int[] nums2 = new int[] {0,0,1,1,1,2,2,3,3,3,4,4,4,4,5,5,6,6,6,8,10,10};
    int[] ans2 = searchRange(nums2, 4);
    for (int n : ans2) {
      System.out.println(n);
    }
    System.out.println();
  }

}
