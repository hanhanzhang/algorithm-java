package com.sdu.algorithm.leetcode;

public class LT0560 {

  private static int subarraySum(int[] nums, int k) {
    if (nums == null || nums.length == 0) return 0;

    // 滑动窗口需要每次只能对一端滑动, 本题目若采用滑动窗口, 则需要两端都滑动, 故不适合

    int cnt = 0;
    // sum[i]表示从0至第i个元素的子数组和, 则 sum[i] - sum[j] = k 即为i到j子数组的和
    int[] sum = new int[nums.length + 1];
    sum[0] = 0;
    for (int i = 1; i <= nums.length; ++i) {
      sum[i] = nums[i - 1] + sum[i - 1];
    }

    for (int j = 1; j < sum.length; j++) {
      for (int i = j-1; i >= 0; i--) {
        if (sum[j] - sum[i] == k) {
          cnt++;
        }
      }
    }

    return cnt;
  }

  public static void main(String[] args) {
    System.out.println(subarraySum(new int[] {1, 1, 1}, 2));
    System.out.println(subarraySum(new int[] {1, 2, 3}, 3));
  }

}
