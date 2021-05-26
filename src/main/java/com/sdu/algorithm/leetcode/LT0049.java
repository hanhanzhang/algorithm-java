package com.sdu.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LT0049 {

  private static List<List<String>> groupAnagrams(String[] strs) {
    if (strs == null || strs.length == 0) {
      return Collections.emptyList();
    }

    Map<String, List<String>> ans = new HashMap<>();
    for (String str : strs) {
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      // key
      List<String> res = ans.computeIfAbsent(new String(chars), k -> new ArrayList<>());
      res.add(str);
    }

    return new ArrayList<>(ans.values());
  }

  public static void main(String[] args) {
    String[] strs = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
    System.out.println(groupAnagrams(strs));

    String[] strs1 = new String[] {"paw", "dad", "bog", "day", "day", "mig", "len", "rat"};
    System.out.println(groupAnagrams(strs1));
  }

}
