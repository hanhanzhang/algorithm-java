package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.Node;
import java.util.LinkedList;
import java.util.List;

public class LT589 {

  private static void preorder(Node root, List<Integer> ans) {
    if (root == null) return;
    ans.add(root.val);
    if (root.children != null) {
      for (Node child : root.children) {
        preorder(child, ans);
      }
    }
  }

  private List<Integer> preorder(Node root) {
    List<Integer> ans = new LinkedList<>();
    preorder(root, ans);
    return ans;
  }

  public static void main(String[] args) {

  }

}
