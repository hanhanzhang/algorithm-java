package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.ArrayUtils;

public class LT034 {


  private static int[] searchRange(int[] nums, int target) {
    if (nums == null || nums.length == 0) return new int[] {-1, -1};
    int l = 0, r = nums.length - 1;
    int[] res = new int[] {-1, -1};
    while (l <= r) {
      int mid = (l + r) / 2;
      if (nums[mid] == target) {
        int lp = mid;
        while (lp >= l && nums[lp] == target) lp -= 1;
        int rp = mid;
        while (rp <= r && nums[rp] == target) rp += 1;
        res[0] = lp + 1;
        res[1] = rp - 1;
        break;
      } else if (nums[mid] < target) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    ArrayUtils.printArray(searchRange(new int[] {5, 5, 5}, 5));
    ArrayUtils.printArray(searchRange(new int[] {5, 7, 7, 8, 8, 10}, 8));
    ArrayUtils.printArray(searchRange(new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 6, 6, 6, 8, 10, 10}, 4));
  }

}
