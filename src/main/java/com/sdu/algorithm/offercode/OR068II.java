package com.sdu.algorithm.offercode;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;

public class OR068II {

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        return l == null ? r : (r == null ? l : root);
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildTree(new Integer[] {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        TreeNode parent = lowestCommonAncestor(root, new TreeNode(5), new TreeNode(4));
        System.out.println(parent.val);

    }
}
