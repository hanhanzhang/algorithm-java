package com.sdu.algorithm.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LT093 {

  private static List<String> restoreIpAddresses(String p, int start, int depth) {
    if (start >= p.length() || depth == 0) {
      return Collections.emptyList();
    }

    if (depth == 1) {
      String e = p.substring(start);
      if (e.length() >= 4 || Integer.parseInt(e) > 255
          || Integer.parseInt(e) < 0 || (e.length() > 1 && e.startsWith("0"))) {
        return Collections.emptyList();
      }

      return Collections.singletonList(e);
    }

    List<String> addresses = new ArrayList<>();
    for (int i = 0; i < 3 && start + i + 1 <= p.length(); ++i) {
      int end = start + i + 1;
      String e = p.substring(start, end);
      if (i > 0 && e.startsWith("0")) {
        continue;
      }
      if (Integer.parseInt(e) > 255 || Integer.parseInt(e) < 0) {
        continue;
      }
      List<String> otherAddresses = restoreIpAddresses(p, end, depth - 1);
      if (otherAddresses.isEmpty()) {
        continue;
      }
      for (String address : otherAddresses) {
        StringBuilder sb = new StringBuilder();
        sb.append(e);
        sb.append(".");
        sb.append(address);
        addresses.add(sb.toString());
      }
    }

    return addresses;
  }

  private static List<String> restoreIpAddresses(String s) {
    if (s == null || s.isEmpty()) return Collections.emptyList();
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
