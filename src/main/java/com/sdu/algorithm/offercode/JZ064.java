package com.sdu.algorithm.offercode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;

public class JZ064 {


  private static int maxWindowValue(ArrayDeque<Integer> window) {
    Iterator<Integer> it = window.iterator();
    int max = Integer.MIN_VALUE;
    while (it.hasNext()) {
      int val = it.next();
      if (max < val) {
        max = val;
      }
    }
    return max;
  }

  private static ArrayList<Integer> maxInWindows(int[] nums, int size) {
    ArrayList<Integer> ans = new ArrayList<>();
    if (nums == null || nums.length == 0 || size == 0) {
      return ans;
    }

    int max = Integer.MIN_VALUE;
    ArrayDeque<Integer> window = new ArrayDeque<>(size);
    for (int num : nums) {
      if (max < num) {
        max = num;
      }
      window.add(num);
      if (window.size() == size) {
        ans.add(max);
      } else if (window.size() > size) {
        int ele = window.poll();
        if (ele == max && num != ele) {
          max = maxWindowValue(window);
        }
        ans.add(max);
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    ArrayList<Integer> ans = maxInWindows(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3);
    System.out.println(ans);

    ArrayList<Integer> ans1 = maxInWindows(new int[]{10, 14, 12, 11}, 5);
    System.out.println(ans1);
  }

}
