package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;

public class LT0101 {

    private static boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
    }

    private static boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    public static void main(String[] args) {
        System.out.println(isSymmetric(TreeUtils.buildTree(new Integer[] {1, 2, 2, 3, 4, 4, 3})));
    }

}
