package com.sdu.algorithm.leetcode;

public class LT014 {

  private static String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    int pos = 0;
    while (true) {
      char c = '0';
      boolean end = false;
      for (int i = 0; i < strs.length; ++i) {
        if (strs[i].length() <= pos) {
          end = true;
          break;
        }
        if (c == '0') {
          c = strs[i].charAt(pos);
        } else if (strs[i].charAt(pos) != c) {
          end = true;
          break;
        }
      }
      if (end) break;
      sb.append(strs[0].charAt(pos++));
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    String[] strs = new String[] {"flower", "flow", "flight"};
    System.out.println(longestCommonPrefix(strs));

    String[] strs1 = new String[] {"a"};
    System.out.println(longestCommonPrefix(strs1));
  }

}
