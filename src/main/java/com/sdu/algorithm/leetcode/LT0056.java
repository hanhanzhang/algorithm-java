package com.sdu.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LT0056 {

  private static int[][] merge(int[][] intervals) {
    if (intervals == null || intervals.length == 0) {
      return intervals;
    }
    Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
    List<int[]> ans = new ArrayList<>();
    int[] cur = intervals[0];
    for (int i = 1; i < intervals.length; ++i) {
      if (cur[1] >= intervals[i][0]) {  // 可合并
        cur = new int[] {cur[0], Math.max(cur[1], intervals[i][1])};
      } else {
        ans.add(cur);
        cur = intervals[i];
      }
    }
    ans.add(cur);

    return ans.toArray(new int[0][]);
  }

  public static void main(String[] args) {
    int[][] intervals = new int[][] {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    int[][] mergeIntervals = merge(intervals);
    for (int[] interval : mergeIntervals) {
      StringBuilder sb = new StringBuilder();
      for (int element : interval) {
        sb.append(element).append(" ");
      }
      System.out.println(sb.toString());
    }
    System.out.println("************");

    int[][] intervals1 = new int[][] {{1, 4}, {2, 3} };
    int[][] mergeIntervals1 = merge(intervals1);
    for (int[] interval : mergeIntervals1) {
      StringBuilder sb = new StringBuilder();
      for (int element : interval) {
        sb.append(element).append(" ");
      }
      System.out.println(sb.toString());
    }
  }

}
