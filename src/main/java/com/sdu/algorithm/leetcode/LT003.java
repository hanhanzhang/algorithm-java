package com.sdu.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LT003 {

  private static int lengthOfLongestSubstring0(String s) {
    if (s == null || s.isEmpty()) return 0;
    char[] chars = s.toCharArray();
    // 滑动窗口解法, 记录窗口的起始位置和记录窗口内的元素
    int windowStart = 0;
    int windowEnd = 0;
    Set<Character> windowElements = new HashSet<>();
    int max = 0;
    while (windowStart < chars.length && windowEnd < chars.length) {
      if (windowElements.add(chars[windowEnd])) {
        windowElements.add(chars[windowEnd]);
        windowEnd += 1;
        int len = windowEnd - windowStart;
        max = len > max ? len : max;

      } else {
        // 移动窗口的起始位置
        if (windowElements.contains(chars[windowStart])) {
          windowElements.remove(chars[windowStart]);
          windowStart += 1;
        }
      }
    }
    return max;
  }

  private static int lengthOfLongestSubstring(String s) {
    if (s == null || s.isEmpty()) return 0;

    char[] chars = s.toCharArray();
    Map<Character, Integer> map = new HashMap<>();
    int[] nearCharPos = new int[chars.length];
    for (int i = 0; i < chars.length; ++i) {
      char c = chars[i];
      int pos = map.getOrDefault(c, -1);
      map.put(c, i);
      nearCharPos[i] = pos;
    }

    // 类似滑动窗口算法, 但是写的有点复杂
    int max = 1;
    // 记录以i结尾最长子串的起始位置
    int[] dp = new int[chars.length];
    dp[0] = 0;
    for (int i = 1; i < chars.length; ++i) {
      int pos = nearCharPos[i];
      if (pos == -1 || pos < dp[i - 1]) {
        // 从i出向前看未出现字符chars[i]
        // 距离i最近的字符的位置比以 i - 1 结尾子串的起始位置要小
        dp[i] = dp[i - 1];
      } else {
        dp[i] = pos + 1;
      }

      // 计算距离
      int len = i - dp[i] + 1;
      max = len > max ? len : max;
    }

    return max;
  }

  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("abcabcbb"));
    System.out.println(lengthOfLongestSubstring("pwwkew"));
    System.out.println(lengthOfLongestSubstring("bbbbb"));

    System.out.println(lengthOfLongestSubstring0("abcabcbb"));
    System.out.println(lengthOfLongestSubstring0("pwwkew"));
    System.out.println(lengthOfLongestSubstring0("bbbbb"));
  }

}
