package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;

import java.util.*;

public class LT0437 {

  // nodeSums: 记录节点对应的所有子路径和
  private static int pathSum(TreeNode root, int sum, Map<TreeNode, List<Integer>> nodeSums) {
    if (root == null) {
      return 0;
    }
    List<Integer> sums = nodeSums.computeIfAbsent(root, k -> new LinkedList<>());
    if (root.left == null && root.right == null) {
      sums.add(root.val);
      return root.val == sum ? 1 : 0;
    }

    sums.add(root.val);
    int cnt = pathSum(root.left, sum, nodeSums)
            + pathSum(root.right, sum, nodeSums)
            + (root.val == sum ? 1 : 0);

    // 左子树
    List<Integer> leftSums = nodeSums.getOrDefault(root.left, Collections.emptyList());
    for (int subSum : leftSums) {
      int ret = subSum + root.val;
      sums.add(ret);
      if (ret == sum) {
        cnt += 1;
      }
    }

    // 右子树
    List<Integer> rightSums = nodeSums.getOrDefault(root.right, Collections.emptyList());
    for (int subSum : rightSums) {
      int ret = subSum + root.val;
      sums.add(ret);
      if (ret == sum) {
        cnt += 1;
      }
    }

    return cnt;
  }

  private static int pathSum(TreeNode root, int sum) {
    return pathSum(root, sum, new HashMap<>());
  }

  public static void main(String[] args) {
    TreeNode root1 = TreeUtils.buildTree(new Integer[] {10, 5, -3, 3, 2, null, 11, 3, -2, null, 1});
    System.out.println(pathSum(root1, 8));

    TreeNode root2 = TreeUtils.buildTree(new Integer[] {1, 2});
    System.out.println(pathSum(root2, 1));
  }

}
