package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.Node;
import java.util.LinkedList;
import java.util.List;

public class LT590 {

  private static void postorder(Node root, List<Integer> ans) {
    if (root == null) return;
    if (root.children != null) {
      for (Node child : root.children) {
        postorder(child, ans);
      }
    }
    ans.add(root.val);
  }

  private static List<Integer> postorder(Node root) {
    List<Integer> ans = new LinkedList<>();
    postorder(root, ans);
    return ans;
  }

  public static void main(String[] args) {

  }

}
