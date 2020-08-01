package com.sdu.algorithm.offercode;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;

import java.util.HashMap;
import java.util.Map;

public class JZ039 {

  private static int treeHeight(TreeNode root, Map<TreeNode, Integer> heights) {
    if (root == null) {
      return 0;
    }
    if (heights.containsKey(root)) {
      return heights.get(root);
    }

    int left = treeHeight(root.left, heights) + 1;
    int right = treeHeight(root.right, heights) + 1;
    heights.put(root, Math.max(left, right));
    return heights.get(root);
  }

  private static boolean IsBalanced_Solution(TreeNode root, Map<TreeNode, Integer> heights) {
    if (root == null) {
      return true;
    }
    int left = treeHeight(root.left, heights);
    int right = treeHeight(root.right, heights);
    if (Math.abs(left - right) > 1) {
      return false;
    }

    return IsBalanced_Solution(root.left, heights) && IsBalanced_Solution(root.right, heights);
  }

  private static boolean IsBalanced_Solution(TreeNode root) {
    if (root == null) {
      return true;
    }

    return IsBalanced_Solution(root, new HashMap<>());
  }

  public static void main(String[] args) {
    TreeNode root = TreeUtils.buildTree(new Integer[] {1, 2, null, null, 3, 4, 5});
    System.out.println(IsBalanced_Solution(root));
  }

}
