package com.sdu.algorithm.leetcode;

public class LT165 {

  private static int compareVersion(String version1, String version2) {
    int v1 = 0;
    int v2 = 0;
    while (v1 < version1.length() && v2 < version2.length()) {
      int e1 = v1;
      while (e1 < version1.length() && version1.charAt(e1) != '.') ++e1;

      int e2 = v2;
      while (e2 < version2.length() && version2.charAt(e2) != '.') ++e2;

      int sub1 = Integer.valueOf(version1.substring(v1, e1));
      int sub2 = Integer.valueOf(version2.substring(v2, e2));
      if (sub1 == sub2) {
        v1 = e1 + 1;
        v2 = e2 + 1;
      } else {
        return sub1 < sub2 ? -1 : 1;
      }
    }

    if (v1 == version1.length() + 1 && v2 == version2.length() + 1) {
      return 0;
    }

    if (v1 == version1.length() + 1) {
      // 判断version2后续的装订版本若都为0, 则返回0, 否则返回-1
      while (v2 < version2.length()) {
        int e2 = v2;
        while (e2 < version2.length() && version2.charAt(e2) != '.') ++e2;
        int sub2 = Integer.valueOf(version2.substring(v2, e2));
        if (sub2 == 0) {
          v2 = e2 + 1;
        } else {
          return -1;
        }
      }
      return 0;
    }

    // 判断version1后续的装订版本若都为0, 则返回0, 否则返回-1
    while (v1 < version1.length()) {
      int e1 = v1;
      while (e1 < version1.length() && version1.charAt(e1) != '.') ++e1;
      int sub1 = Integer.valueOf(version1.substring(v1, e1));
      if (sub1 == 0) {
        v1 = e1 + 1;
      } else {
        return 1;
      }
    }
    return 0;

  }

  public static void main(String[] args) {
    System.out.println(compareVersion("0.1", "1.1"));
    System.out.println(compareVersion("1.0.1", "1"));
    System.out.println(compareVersion("7.5.2.4", "7.5.3"));
    System.out.println(compareVersion("1.01", "1.001"));
    System.out.println(compareVersion("1.0", "1.0.0"));
  }

}
