package com.sdu.algorithm.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LT0215 {

  private static int findKthLargest(int[] nums, int k) {
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

  public static void main(String[] args) {
    int[] nums = new int[] {3, 2, 1, 5, 6, 4};
    System.out.println(findKthLargest(nums, 2));
    System.out.println(findKthLargest(nums, 2));

    int[] nums1 = new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6};
    System.out.println(findKthLargest(nums1, 4));
    System.out.println(findKthLargest(nums1, 4));
  }

}
