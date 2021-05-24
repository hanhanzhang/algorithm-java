package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;

public class LT0129 {

    private static int sumNumbers(TreeNode root, int pathSum) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return pathSum * 10  + root.val;
        }
        // 左子树
        int leftSum = sumNumbers(root.left, pathSum * 10 + root.val);
        int rightSum = sumNumbers(root.right, pathSum * 10 + root.val);
        return leftSum + rightSum;
    }

    private static int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildTree(new Integer[] {4, 9, 0, 5, 1});
        System.out.println(sumNumbers(root));
    }

}
