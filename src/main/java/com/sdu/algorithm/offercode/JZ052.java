package com.sdu.algorithm.offercode;

public class JZ052 {

  private static boolean dfs(char[] str, int s, char[] pattern, int p) {
    if (s == str.length && p == pattern.length) {
      return true;
    }
    // pattern到达尾部, str未到尾部
    if (s != str.length && p == pattern.length) {
      return false;
    }

    if (p + 1 < pattern.length && pattern[p + 1] == '*') {
      if ((s != str.length && str[s] == pattern[p])
          || (s != str.length && pattern[p] == '.')) {
        return dfs(str, s, pattern, p + 2)        // aaa, a.*aa
            || dfs(str, s + 1, pattern, p + 2) // aaa, aa*a
            || dfs(str, s + 1, pattern, p);      // aaa, a*
      } else {
        return dfs(str, s, pattern, p + 2);
      }
    }

    if ((s != str.length && str[s] == pattern[p])
        || (s != str.length && pattern[p] == '.')) {
      return dfs(str, s + 1, pattern, p + 1);
    }

    return false;
  }

  private static boolean match(char[] str, char[] pattern) {
    if (str == null || pattern == null) {
      return false;
    }
    return dfs(str, 0, pattern, 0);
  }

  public static void main(String[] args) {
    System.out.println(match(new char[]{'a', 'a', 'a', 'b'}, new char[] {'a', '*', 'b'}));
    System.out.println(match("aaa".toCharArray(), "a.a".toCharArray()));
    System.out.println(match("aaa".toCharArray(), "ab*ac*a".toCharArray()));
    System.out.println(match("aaa".toCharArray(), "aa.a".toCharArray()));
    System.out.println(match("aaa".toCharArray(), "ab*a".toCharArray()));
    // check two character
    System.out.println(match("".toCharArray(), ".*".toCharArray()));
  }

}
