package com.sdu.algorithm.leetcode;

public class LT0014 {

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
    System.out.println(longestCommonPrefix(new String[] {"flower", "flow", "flight"}));
    System.out.println(longestCommonPrefix(new String[] {"a"}));
  }

}
