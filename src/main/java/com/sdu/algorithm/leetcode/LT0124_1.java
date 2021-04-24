package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;

public class LT0124_1 {

    private static Integer maxSum = Integer.MIN_VALUE;

    private static int intervalMaxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 左子树
        int leftMaxSum = intervalMaxPathSum(root.left);
        // 右子树
        int rightMaxSum = intervalMaxPathSum(root.right);

        int val = leftMaxSum + rightMaxSum + root.val;
        int ret = Math.max(root.val, Math.max(leftMaxSum, rightMaxSum) + root.val);
        maxSum = Math.max(val, ret) > maxSum ? Math.max(val, ret) : maxSum;

        return ret;
    }

    private static int maxPathSum(TreeNode root) {
        intervalMaxPathSum(root);
        return maxSum;
    }

    public static void main(String[] args) {
        TreeNode root1 = TreeUtils.buildTree(new Integer[] {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
        System.out.println(maxPathSum(root1));

        TreeNode root2 = TreeUtils.buildTree(new Integer[] {9, 6, -3, null, null, -6, 2, null, null, 2, null, -6, -6, -6});
        System.out.println(maxPathSum(root2));

        TreeNode root3 = TreeUtils.buildTree(new Integer[] {0});
        System.out.println(maxPathSum(root3));
    }

}
