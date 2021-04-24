package com.sdu.algorithm.recruitment;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;

/**
 * 面试题
 * */
public class RM0412 {

  private int pathSum = 0;


  private int[] pathSum0(TreeNode node, int sum) {
    if (node == null) {
      return null;
    }
    int[] leftNodePathSum = pathSum0(node.left, sum);
    int[] rightNodePathSum = pathSum0(node.right, sum);

    //
    int len = (leftNodePathSum != null ? leftNodePathSum.length : 0)
        + (rightNodePathSum != null ? rightNodePathSum.length : 0);
    int[] r = new int[len + 1];
    r[0] = node.val;
    if (r[0] == sum) {
      pathSum += 1;
    }

    int i = 1;
    if (leftNodePathSum != null) {
      for (int m = 0; m < leftNodePathSum.length; ++m, ++i) {
        int target = leftNodePathSum[m] + node.val;
        if (target == sum) {
          pathSum += 1;
        }
        r[i] = target;
      }
    }

    if (rightNodePathSum != null) {
      for (int m = 0; m < rightNodePathSum.length; ++m, ++i) {
        int target = rightNodePathSum[m] + node.val;
        if (target == sum) {
          pathSum += 1;
        }
        r[i] = target;
      }
    }

    return r;
  }

  private  int pathSum(TreeNode root, int sum) {
    pathSum0(root, sum);
    return pathSum;
  }

  public static void main(String[] args) {
    TreeNode node = TreeUtils.buildTree(new Integer[] {1});

    RM0412 rt0412 = new RM0412();
    System.out.println(rt0412.pathSum(node, 1));
  }

}
