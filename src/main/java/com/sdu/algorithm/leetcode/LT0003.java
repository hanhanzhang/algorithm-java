package com.sdu.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LT0003 {

  private static int lengthOfLongestSubstring(String s) {
    if (s == null || s.isEmpty()) return 0;
    // 双指针
    Set<Character> windowElements = new HashSet<>();
    int max = 1, start = 0;
    windowElements.add(s.charAt(0));
    for (int i = 1; i < s.length(); ++i) {
      char ch = s.charAt(i);
      if (windowElements.contains(ch)) {
        // 移除元素
        int j = start;
        for (; s.charAt(j) != ch; ++j) {
          windowElements.remove(s.charAt(j));
        }
        start = j + 1;
      } else {
        windowElements.add(ch);
        max = Math.max(max, i - start + 1);
      }
    }
    return max;
  }

  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("abcabcbb"));
    System.out.println(lengthOfLongestSubstring("pwwkew"));
    System.out.println(lengthOfLongestSubstring("bbbbb"));
    System.out.println(lengthOfLongestSubstring("dvdf"));
  }

}
