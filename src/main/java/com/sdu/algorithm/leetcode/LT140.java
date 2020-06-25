package com.sdu.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LT140 {

  private static List<String> dfs(String s, int start, Set<String> dict, Map<Integer, List<String>> memo) {
    if (start >= s.length()) {
      return Collections.singletonList("");
    }
    if (memo.containsKey(start)) {
      return memo.get(start);
    }
    List<String> ans = new ArrayList<>();
    for (int i = start; i < s.length(); ++i) {
      String word = s.substring(start, i + 1);
      if (dict.contains(word)) {
        List<String> ret = dfs(s, i + 1, dict, memo);
        if (ret == null || ret.isEmpty()) {
          continue;
        }
        for (String subWords : ret) {
          ans.add(word + " " + subWords);
        }
      }
    }
    memo.put(start, ans);
    return ans;
  }

  private static List<String> wordBreak(String s, List<String> wordDict) {
    if (s == null || s.isEmpty()) {
      return new ArrayList<>();
    }
    Set<String> dict = new HashSet<>(wordDict);
    // 记忆化搜索(暴力DFS超时)
    Map<Integer, List<String>> memo = new HashMap<>();
    return dfs(s, 0, dict, memo);
  }

  public static void main(String[] args) {
    List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
    System.out.println(wordBreak("catsanddog", wordDict));
  }

}
