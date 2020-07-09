package com.sdu.algorithm.recruitment;

import java.util.ArrayList;
import java.util.List;

public class RM0009 {

  private static List<List<Integer>> eatBread(int n) {
    if (n <= 0) {
      return null;
    }
    List<List<Integer>> ans = new ArrayList<>();
    for (int i = 1; i <= 3; ++i) {
      if (n - i < 0) {
        continue;
      }
      if (n - i == 0) {
        List<Integer> sub = new ArrayList<>();
        sub.add(i);
        ans.add(sub);
        break;
      }
      List<List<Integer>> ret = eatBread(n - i);
      if (ret != null) {
        for(List<Integer> child : ret) {
          child.add(i);
          ans.add(child);
        }
      }
    }
    return ans;
  }

  @SuppressWarnings("unchecked")
  private static List<List<Integer>> eatBread01(int n) {
    if (n <= 0) {
      return null;
    }
    List<List<Integer>>[] dp = new ArrayList[n + 1];
    dp[0] = null;
    for (int i = 1; i <= n; ++i) {
      List<List<Integer>> ret = new ArrayList<>();
      for (int j = 1; j <= 3; ++j) {
        if (i - j < 0) {
          continue;
        }
        if (i - j == 0) {
          List<Integer> ans = new ArrayList<>();
          ans.add(j);
          ret.add(ans);
        } else {
          List<List<Integer>> children = dp[i -j];
          if (children != null) {
            for (List<Integer> child : children) {
              List<Integer> ans = new ArrayList<>(child);
              ans.add(j);
              ret.add(ans);
            }
          }
        }
        dp[i] = ret;
      }
    }
    return dp[n];
  }


  public static void main(String[] args) {
    System.out.println(eatBread(3));
    System.out.println(eatBread(4));

    System.out.println("**********");

    System.out.println(eatBread01(3));
  }

}
