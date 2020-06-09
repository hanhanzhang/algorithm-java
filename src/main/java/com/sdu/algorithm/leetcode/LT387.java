package com.sdu.algorithm.leetcode;

public class LT387 {

  private static int firstUniqChar(String s) {
    if (s == null || s.isEmpty()) return -1;
    // 若char出现多次, 标识为-2
    int[][] charCnt = new int[26][1];
    for (int i = 0; i < 26; ++i) {
      charCnt[i] = new int[] {-1};
    }

    for (int i = 0; i < s.length(); ++i) {
      char c = s.charAt(i);
      int pos = c - 'a';
      if (charCnt[pos][0] == -1) {        // 尚未出现过
        charCnt[pos][0] = i;
      } else if (charCnt[pos][0] >= 0) {  // 已出现过
        charCnt[pos][0] = -2;
      }
    }

    int minPos = s.length();
    for (int i = 0; i < charCnt.length; ++i) {
      if (charCnt[i][0] >= 0 && charCnt[i][0] < minPos) {
        // 出现仅一次
        minPos = charCnt[i][0];
      }
    }
    return minPos == s.length() ? -1 : minPos;
  }

  public static void main(String[] args) {
    System.out.println(firstUniqChar("leetcode"));
    System.out.println(firstUniqChar("loveleetcode"));
  }

}
