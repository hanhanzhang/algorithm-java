package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;

public class LT0110 {

    private static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    private static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    public static void main(String[] args) {
        TreeNode root1 = TreeUtils.buildTree(new Integer[] {3, 9, 20, null, null, 15, 7});
        System.out.println(isBalanced(root1));

        TreeNode root2 = TreeUtils.buildTree(new Integer[] {1, 2, 2, 3, 3, null, null, 4, 4});
        System.out.println(isBalanced(root2));

        TreeNode root3 = TreeUtils.buildTree(new Integer[] {});
        System.out.println(isBalanced(root3));
    }

}
