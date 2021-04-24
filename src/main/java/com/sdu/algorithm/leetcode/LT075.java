package com.sdu.algorithm.leetcode;

public class LT075 {

  private static void sortColors(int[] nums) {
    int[] colorPos = new int[]{-1, -1, -1};
    for (int i = 0; i < nums.length; ++i) {
      int color = nums[i];
      int nextColor = color + 1;
      if (nextColor > 2) {
        // 当前元素是蓝色, 则不需要调整
        colorPos[color] = colorPos[color] == -1 ? i : colorPos[color];
      } else {
        // 找到不等于-1的下个颜色的位置
        while (nextColor <= 2 && colorPos[nextColor] == -1) {
          nextColor++;
        }
        if (nextColor > 2) {
          // 没有找到, 则不需要调整
          colorPos[color] = colorPos[color] != -1 ? colorPos[color] : i;
          continue;
        }
        // 调整
        int k = i;
        for (; k > colorPos[nextColor]; --k) {
          nums[k] = nums[k - 1];
        }
        nums[k] = color;
        colorPos[color] = colorPos[color] != -1 ? colorPos[color] : k;
        while (nextColor <= 2 && colorPos[nextColor] != -1) {
          colorPos[nextColor] = colorPos[nextColor] + 1;
          nextColor++;
        }
      }
    }
  }

  private static void sortColors01(int[] nums) {
    // p0: 0的最右边边界, p2: 2的最左边界
    int p0 = 0, p2 = nums.length - 1;
    int cur = 0;
    while (cur <= p2) {
      int color = nums[cur];
      if (color == 2) {
        nums[cur] = nums[p2];
        nums[p2--] = color;
        continue;
      }
      if (color == 0) {
        nums[cur++] = nums[p0];
        nums[p0++] = color;
        continue;
      }
      ++cur;
    }
  }

  public static void main(String[] args) {
    int[] colors = new int[] {1,2,2,2,2,0,0,0,1,1};
    sortColors(colors);
    for (int color : colors) {
      System.out.println(color);
    }

    int[] colors1 = new int[] {1, 0, 1};
    sortColors(colors1);
    for (int color : colors1) {
      System.out.println(color);
    }
  }

}
