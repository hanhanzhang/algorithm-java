package com.sdu.algorithm.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LT071 {

  private static void simplifyPath(Deque<String> deque, String dir) {
    switch (dir) {
      case ".":
        break;
      case "..":
        if (!deque.peek().equals("/")) {
          deque.pop();
        }
        break;
      default:
        deque.push(dir);
        break;
    }
  }

  private static String simplifyPath(String path) {
    Deque<String> deque = new LinkedList<>();
    deque.push("/");

    int start = 0;
    int end = 0;
    while (end < path.length()) {
      if (path.charAt(start) == '/') {
        start += 1;
      }
      if (path.charAt(end) == '/' && end > start) {
        String dir = path.substring(start, end);
        simplifyPath(deque, dir);
        start = end + 1;
      }
      end += 1;
    }

    if (end > start) {
      String dir = path.substring(start, end);
      simplifyPath(deque, dir);
    }

    StringBuilder sb = new StringBuilder();
    int size = deque.size();
    int index = 0;
    while (!deque.isEmpty()) {
      String dir = deque.pollLast();
      sb.append(dir);
      if (dir.equals("/")) {
        continue;
      }
      sb.append(++index == size - 1 ? "" : "/");
    }

    return sb.toString();

  }

  public static void main(String[] args) {
    System.out.println(simplifyPath("/../"));
    System.out.println(simplifyPath("/home//foo/"));
    System.out.println(simplifyPath("/a/./b/../../c/"));
    System.out.println(simplifyPath("/a/../../b/../c//.//"));
    System.out.println(simplifyPath("/a//b////c/d//././/.."));
  }

}
