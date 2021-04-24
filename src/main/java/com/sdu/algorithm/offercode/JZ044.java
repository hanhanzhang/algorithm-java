package com.sdu.algorithm.offercode;

import java.util.Stack;

public class JZ044 {

  private static String ReverseSentence(String str) {
    if (str == null || str.trim().isEmpty()) {
      return str;
    }
    String[] words = str.trim().split(" ");
    Stack<String> stack = new Stack<>();
    for (String word : words) {
      stack.push(word);
    }
    StringBuilder res = new StringBuilder(stack.pop());
    while (!stack.isEmpty()) {
      res.append(" ").append(stack.pop());
    }
    return res.toString();
  }

  public static void main(String[] args) {
    System.out.println(ReverseSentence("student. a am I"));
  }

}
