package com.sdu.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LT494 {

  /*
   * 本方法运行超时, 解决办法: 空间换时间
   * */
  private static int findTargetSumWays(int[] nums, int S) {
    /*
     * 两种思路:
     *
     * 1: 深度搜索
     *
     * 2: 动态规划
     *
     *    本题选择动态规划实现, dp[i] 表示已nums[i]结尾的所有全部元素和
     * */
    if (nums == null || nums.length == 0) return 0;
    if (nums.length == 1) {
      return nums[0] == S || nums[0] == -S ? 1 : 0;
    }
    List<Integer> dp = new ArrayList<>();
    dp.add(nums[0]);
    dp.add(-nums[0]);

    for (int i = 1; i < nums.length; ++i) {
      List<Integer> newSubSums = new ArrayList<>();
      for (int subSum : dp) {
        newSubSums.add(subSum + nums[i]);
        newSubSums.add(subSum - nums[i]);
      }
      dp = newSubSums;
    }

    return (int) dp.stream().filter(p -> p == S).count();
  }

  private static int findTargetSumWays1(int[] nums, int S) {
    /*
     * 两种思路:
     *
     * 1: 深度搜索
     *
     * 2: 动态规划
     *
     *    本题选择动态规划实现, dp[i] 表示已nums[i]结尾的所有全部元素和
     * */
    if (nums == null || nums.length == 0) return 0;
    if (nums.length == 1) {
      return nums[0] == S || nums[0] == -S ? 1 : 0;
    }

    int[][] dp = new int[nums.length][];
    dp[0] = new int[2];
    dp[0][0] = nums[0];
    dp[0][1] = -nums[0];

    int ans = 0;
    int cnt = 2;
    for (int i = 1; i < nums.length; ++i) {
      dp[i] = new int[2 * cnt];
      int[] subSums = dp[i - 1];
      int newCnt = 0;
      for (int j = 0; j < cnt; ++j) {
        if (i == nums.length - 1) {
          ans += subSums[j] + nums[i] == S ? 1 : 0;
          ans += subSums[j] - nums[i] == S ? 1 : 0;
        } else {
          dp[i][newCnt++] = subSums[j] + nums[i];
          dp[i][newCnt++] = subSums[j] - nums[i];
        }
      }
      cnt = newCnt;
    }

    return ans;
  }

  public static void main(String[] args) {
    System.out.println(findTargetSumWays(new int[] {1, 1, 1, 1, 1}, 3));
    System.out.println(findTargetSumWays(new int[] {1}, 1));
    System.out.println(findTargetSumWays(new int[] {1, 0}, 1));

    System.out.println(findTargetSumWays1(new int[] {1, 1, 1, 1, 1}, 3));
    System.out.println(findTargetSumWays1(new int[] {1}, 1));
    System.out.println(findTargetSumWays1(new int[] {1, 0}, 1));
  }

}
