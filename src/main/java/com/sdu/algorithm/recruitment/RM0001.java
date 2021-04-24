package com.sdu.algorithm.recruitment;

import java.util.ArrayList;
import java.util.List;

public class RM0001 {

  private static List<List<Integer>> permutation(int[] array, int i, int[] visited) {
    if (i == array.length) {
      return null;
    }

    List<List<Integer>> ans = new ArrayList<>();
    for(int k = 0; k < array.length; ++k) {
      if(visited[k] == 1) {
        continue;
      }
      visited[k] = 1;
      List<List<Integer>> ret = permutation(array, i + 1, visited);
      if (ret == null) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(array[k]);
        ans.add(res);
      } else {
        for (List<Integer> sub : ret ){
          sub.add(0, array[k]);
          ans.add(sub);
        }
      }
      visited[k] = 0;
    }

    return ans;
  }

  private static List<List<Integer>> permutation(int[] array) {
    assert array != null && array.length != 0;
    return permutation(array, 0, new int[array.length]);
  }

  public static void main(String[] args) {
    System.out.println(permutation(new int[] {1, 2, 3}));
  }

}
