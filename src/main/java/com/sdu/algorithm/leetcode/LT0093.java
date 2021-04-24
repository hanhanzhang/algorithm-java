package com.sdu.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LT0093 {

  private static List<String> restoreIpAddresses(String s, int start, int depth) {
    if (s == null || s.isEmpty() || start >= s.length() || depth == 0) {
      return Collections.emptyList();
    }
    if (depth == 1) {
      String tmp = s.substring(start);
      // 整数越界
      if ((tmp.length() > 1 && tmp.charAt(0) == '0') || tmp.length() >= 4
              ||  Integer.parseInt(tmp) > 255) {
        return Collections.emptyList();
      }
      return Collections.singletonList(tmp);
    }

    List<String> ans = new ArrayList<>();
    for (int i = 0; i < 3 && start + i + 1 <= s.length(); ++i) {
      String ops = s.substring(start, start + i + 1);
      if ((i > 0 && ops.startsWith("0")) || Integer.parseInt(ops) > 255) {
        break;
      }
      List<String> ret = restoreIpAddresses(s, start + i + 1, depth - 1);
      for (String sub : ret) {
        StringBuilder tmp = new StringBuilder(ops);
        tmp.append(".").append(sub);
        ans.add(tmp.toString());
      }
    }

    return ans;
  }

  private static List<String> restoreIpAddresses(String s) {
    return restoreIpAddresses(s, 0, 4);
  }

  public static void main(String[] args) {
    List<String> address = restoreIpAddresses("25525511135");
    System.out.println(address);

    List<String> address1 = restoreIpAddresses("0000");
    System.out.println(address1);

    List<String> address2 = restoreIpAddresses("010010");
    System.out.println(address2);
  }

}
