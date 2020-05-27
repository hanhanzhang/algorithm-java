package com.sdu.algorithm.array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LT215 {

  private static int findKthLargest1(int[] nums, int k) {
    // 大顶堆, 保留最大的K个元素
    PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(Integer::intValue));

    for (int num : nums) {
      heap.add(num);
      if (heap.size() > k) {
        heap.poll();
      }
    }
    return heap.poll();
  }

  private static int findKthLargest(int[] nums, int k) {
    // k趟冒泡
    for (int i = 0; i < k; ++i) {
      for (int m = 1; m < nums.length - i; ++m) {
        if (nums[m] < nums[m - 1]) {
          int tmp = nums[m];
          nums[m] = nums[m - 1];
          nums[m - 1] = tmp;
        }
      }
    }

    return nums[nums.length - k];
  }

  public static void main(String[] args) {
    int[] nums = new int[] {3, 2, 1, 5, 6, 4};
    System.out.println(findKthLargest(nums, 2));
    System.out.println(findKthLargest1(nums, 2));

    int[] nums1 = new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6};
    System.out.println(findKthLargest(nums1, 4));
    System.out.println(findKthLargest1(nums1, 4));
  }

}
