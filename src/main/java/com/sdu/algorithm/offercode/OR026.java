package com.sdu.algorithm.offercode;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;

public class OR026 {

    private static boolean isSubStructure(TreeNode A, TreeNode B, TreeNode origin) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        if (A.val == B.val
                && isSubStructure(A.left, B.left, origin)
                && isSubStructure(A.right, B.right, origin)) {
            return true;
        }
        return isSubStructure(A.left, origin, origin) || isSubStructure(A.right, origin, origin);
    }

    private static boolean isSubStructure(TreeNode A, TreeNode B) {
        // TODO: 2021/3/31 相同的结构, 遍历结果肯定为子串
        if (B == null || A == null) {
            return false;
        }
        return isSubStructure(A, B, B);
    }

    public static void main(String[] args) {
        TreeNode A1 = TreeUtils.buildTree(new Integer[] {1, 2, 3});
        TreeNode B1 = TreeUtils.buildTree(new Integer[] {3, 1});
        System.out.println(isSubStructure(A1, B1));

        TreeNode A2 = TreeUtils.buildTree(new Integer[] {3, 4, 5, 1, 2});
        TreeNode B2 = TreeUtils.buildTree(new Integer[] {4, 1});
        System.out.println(isSubStructure(A2, B2));
    }

}
