package com.sdu.algorithm.offercode;

import com.sdu.algorithm.utils.TreeNode;

import static com.sdu.algorithm.utils.TreeUtils.buildTree;

public class OR028 {

    private static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right != null) {
            return left.val == right.val
                    && isSymmetric(left.left, right.right)
                    && isSymmetric(left.right, right.left);
        }
        return false;
    }

    private static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public static void main(String[] args) {
        System.out.println(isSymmetric(buildTree(new Integer[] {1, 2, 2, 3, 4, 4, 3})));
        System.out.println(isSymmetric(buildTree(new Integer[] {1, 2, 2, null, 3, null, 3})));
    }

}
