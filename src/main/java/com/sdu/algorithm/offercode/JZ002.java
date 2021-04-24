package com.sdu.algorithm.offercode;

public class JZ002 {

  private static String replaceSpace(StringBuffer str) {
    int len = str.length();
    for (int i = 0; i < len; ++i) {
      if (str.charAt(i) == ' ') {
        // 添加两个空格
        str.append("  ");
      }
    }
    int pos = str.length() - 1;
    for (int i = len - 1; i >= 0; --i) {
      if (str.charAt(i) == ' ') {
        str.setCharAt(pos--, '0');
        str.setCharAt(pos--, '2');
        str.setCharAt(pos--, '%');
      } else {
        str.setCharAt(pos--, str.charAt(i));
      }
    }
    return str.toString();
  }

  public static void main(String[] args) {
    StringBuffer sb = new StringBuffer("We Are Happy");
    System.out.println(replaceSpace(sb));
  }

}
