package com.sdu.algorithm.offercode;

import com.sdu.algorithm.utils.ListUtils;
import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;

public class OR027 {

    private static TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 交换左右节点
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildTree(new Integer[] {4, 2, 7, 1, 3, 6, 9});
        TreeNode newRoot = mirrorTree(root);
        ListUtils.printList(TreeUtils.layerTravel(newRoot));
    }

}
