package com.sdu.algorithm.offercode;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class JZ029 {

  private static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
    // TopN问题: 堆排序
    ArrayList<Integer> ans = new ArrayList<>();
    if (input == null || input.length == 0 || input.length < k || k == 0) {
      return ans;
    }
    PriorityQueue<Integer> heap = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
    for (int num : input) {
      heap.add(num);
      if (heap.size() > k) {
        heap.poll();
      }
    }
    ans.addAll(heap);
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(GetLeastNumbers_Solution(new int[] {4, 5, 1, 6, 2, 7, 3, 8}, 4));
    System.out.println(GetLeastNumbers_Solution(new int[] {4, 5, 1, 6, 2, 7, 3, 8}, 0));
  }

}
