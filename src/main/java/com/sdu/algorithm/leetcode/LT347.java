package com.sdu.algorithm.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LT347 {

  private static int[] topKFrequent(int[] nums, int k) {
    // 记录频次
    Map<Integer, Integer> numToCnt = new HashMap<>();
    for (int num : nums) {
      int cnt = numToCnt.computeIfAbsent(num, key -> 0);
      numToCnt.put(num, cnt + 1);
    }
    // 大顶推
    PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
    for (Map.Entry<Integer, Integer> entry : numToCnt.entrySet()) {
      heap.add(new int[] {entry.getKey(), entry.getValue()});
      if (heap.size() > k) {
        heap.poll();
      }
    }

    int[] ans = new int[k];
    int pos = 0;
    while (!heap.isEmpty()) {
      int[] element = heap.poll();
      ans[pos++] = element[0];
    }

    return ans;
  }

  public static void main(String[] args) {
    int[] ans = topKFrequent(new int[]{1, 1, 1, 2, 2, 3, 3, 3}, 2);
    for (int a : ans) {
      System.out.println(a);
    }
    System.out.println("*******");

    int[] ans1 = topKFrequent(new int[]{5, 3, 1, 1, 1, 3, 73, 1}, 2);
    for (int a : ans1) {
      System.out.println(a);
    }
  }

}
