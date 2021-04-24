package com.sdu.algorithm.leetcode;

public class LT091 {

  private static int numDecodings(String s) {
    char[] chars = s.toCharArray();
    if (chars.length == 0 || chars[0] == '0' ) {
      return 0;
    }
    if (chars.length == 1) {
      return 1;
    }

    int[] dp = new int[chars.length];
    dp[0] = 1;

    for (int i = 1; i < chars.length; ++i) {
      if (chars[i] == '0') {
        if (chars[i - 1] != '1' && chars[i - 1] != '2') {
          return 0;
        } else {
          dp[i] = i >= 2 ? dp[i - 2] : 1;
        }
        continue;
      }
      switch (chars[i - 1]) {
        case '2':
          dp[i] = chars[i] <= '6' ? dp[i - 1] + (i == 1 ? 1 : dp[i - 2])
                                  : dp[i - 1];
          break;
        case '1':
          dp[i] = dp[i - 1] + (i > 1 ? dp[i - 2] : 1);
          break;
        case '0': // i > 2
          switch (chars[i - 2]) {
            case '1':
              dp[i] = dp[i - 2];
              break;
            case '2':
              if (chars[i] <= '6') {
                dp[i] = dp[i -2];
                break;
              }
            default:
              return 0;
          }
          break;
        default:
          dp[i] = dp[i - 1];

      }
    }

    return dp[chars.length - 1];
  }

  public static void main(String[] args) {
    System.out.println(numDecodings("110"));
  }

}
