package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javafx.util.Pair;

public class LT437 {

  // 返回以root为根节点的所有子路径的和
  private static Pair<Integer, List<Integer>> pathSums(TreeNode root, int sum) {
    if (root == null) {
      return new Pair<>(0, Collections.emptyList());
    }
    Pair<Integer, List<Integer>> left = pathSums(root.left, sum);
    Pair<Integer, List<Integer>> right = pathSums(root.right, sum);

    int num = root.val == sum ? 1 + left.getKey() : left.getKey();
    List<Integer> result = new LinkedList<>();

    // 左子树
    for (int s : left.getValue()) {
      int newSum = root.val + s;
      if (newSum == sum) {
        num += 1;
      }
      result.add(newSum);
    }
    // 右子树
    num += right.getKey();
    for (int s : right.getValue()) {
      int newSum = root.val + s;
      if (newSum == sum) {
        num += 1;
      }
      result.add(newSum);
    }
    // 以当前节点为结尾的路径
    result.add(root.val);
    return new Pair<>(num, result);
  }

  private static int pathSum(TreeNode root, int sum) {
    if (root == null) {
      return 0;
    }
    return pathSums(root, sum).getKey();
  }

  public static void main(String[] args) {
    TreeNode root = TreeUtils.buildTree(new Integer[] {10, 5, -3, 3, 2, null, 11, 3, -2, null, 1});
    System.out.println(pathSum(root, 8));
  }

}
