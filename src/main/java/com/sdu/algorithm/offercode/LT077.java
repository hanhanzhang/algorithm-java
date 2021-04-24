package com.sdu.algorithm.offercode;

import java.util.ArrayList;
import java.util.List;

public class LT077 {

  private static List<List<Integer>> combine(int[] array, int pos, int selected, int k) {
    if (selected == k) {
      return null;
    }
    List<List<Integer>> ans = new ArrayList<>();
    for (int i = pos; i < array.length; ++i) {
      List<List<Integer>> sub = combine(array, i + 1, selected + 1, k);
      if (sub == null) {
        List<Integer> child = new ArrayList<>();
        child.add(array[i]);
        ans.add(child);
      } else {
        for(List<Integer> child : sub) {
          child.add(array[i]);
          ans.add(child);
        }
      }
    }
    return ans;
  }

  private static List<List<Integer>> combine(int n, int k) {
    if (n <= 0 || k <= 0 || k > n) {
      return new ArrayList<>();
    }
    int[] array = new int[n];
    for (int i = 1; i <= n; ++i) {
      array[i - 1] = i;
    }
    return combine(array, 0, 0, k);
  }

  public static void main(String[] args) {
    System.out.println(combine(5, 3));
    System.out.println(combine(4, 3));
  }

}
