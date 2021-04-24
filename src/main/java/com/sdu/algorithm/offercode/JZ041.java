package com.sdu.algorithm.offercode;

import java.util.ArrayList;

public class JZ041 {

    public static class Solution1 {
        // 前缀和

        public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            for (int i = 1; i <= sum / 2 + 1; ++i) {
                int subSum = i;
                for (int j = i + 1; j <= sum / 2 + 1; ++j) {
                    subSum += j;
                    if (subSum == sum) {
                        ArrayList<Integer> ret = new ArrayList<>();
                        for (int m = i; m <= j; ++m) {
                            ret.add(m);
                        }
                        ans.add(ret);
                        break;
                    }
                    if (subSum > sum) {     // 减枝
                        break;
                    }
                }
            }
            return ans;
        }

    }

    public static class Solution2 {

        // 滑动窗口
        public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            int i = 1, j = 1;
            int ret = 0;
            while (j <= sum) {
                if (ret == sum) {
                    ArrayList<Integer> window = new ArrayList<>();
                    for (int m = i; m < j; ++m) {
                        window.add(m);
                    }
                    ans.add(window);
                    // 移动i
                    ret -= i;
                    i += 1;
                } else if (ret < sum) {
                    ret += j;
                    j += 1;
                } else {
                    // 保持j不动, 移动i
                    ret -= i;
                    i += 1;
                }
            }
            return ans;
        }

    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> ans = Solution1.FindContinuousSequence(100);
        for (ArrayList<Integer> ret : ans) {
            System.out.println(ret);
        }

        System.out.println("****************");

        ArrayList<ArrayList<Integer>> ans1 = Solution2.FindContinuousSequence(3);
        for (ArrayList<Integer> ret : ans1) {
            System.out.println(ret);
        }
    }
}
