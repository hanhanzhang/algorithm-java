package com.sdu.algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;

public class LT0022 {

  /**
   * @param ret   中间结果
   * @param left  剩余左括号数量
   * @param right 剩余右括号数量
   * @param ans   有效括号结果集
   * */
  private static void dfs(String ret, int left, int right, List<String> ans) {
    if (left == 0 && right == 0) {
      ans.add(ret);
      return;
    }
    if (left > right) {
      // 剪枝(左括号剩余量多余右括号, 则说明不是有效的括号)
      return;
    }
    if (left > 0) {
      dfs(ret + "(", left - 1, right, ans);
    }

    if (right > 0) {
      dfs(ret + ")", left, right - 1, ans);
    }
  }

  private static List<String> generateParenthesis(int n) {
    // 类似组合
    List<String> ans = new LinkedList<>();
    dfs("", n, n, ans);
    return ans;
  }

  public static void main(String[] args) {
    List<String> result = generateParenthesis(3);
    for (String pattern : result) {
      System.out.println(pattern);
    }

    System.out.println("********");

    List<String> result1 = generateParenthesis(0);
    for (String pattern : result1) {
      System.out.println(pattern);
    }
  }

}
