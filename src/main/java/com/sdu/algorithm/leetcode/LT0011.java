package com.sdu.algorithm.leetcode;

public class LT0011 {

  private static int maxArea(int[] height) {
    /*
     * 双指针
     *
     * Area = Math.min(height[l], height[h]) * (h - l)
     * */
    int l = 0, h = height.length - 1;
    int ans = Integer.MIN_VALUE;
    while (l < h) {
      int area = Math.min(height[l], height[h]) * (h -l);
      if (area > ans) {
        ans = area;
      }
      if (height[l] < height[h]) {
        ++l;
      } else {
        --h;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
  }

}
