package com.sdu.algorithm.offercode;

import com.sdu.algorithm.utils.ListUtils;
import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;

public class OR007 {

    private static TreeNode buildTree(int[] preorder, int[] inorder, int ps, int is, int ie) {
        if (ps >= preorder.length || is < 0 || ie >= inorder.length || is > ie) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[ps]);
        int pos = -1;
        for (int i = is; i <= ie; ++i) {
            if (inorder[i] == preorder[ps]) {
                pos = i;
                break;
            }
        }
        int leftLen = pos - is;
        // 构建左子树
        root.left = buildTree(preorder, inorder, ps + 1, is, pos - 1);
        // 构建右子树
        root.right = buildTree(preorder, inorder, ps + leftLen + 1, pos + 1, ie);
        return root;
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        // TODO: 2021/3/31 非递归方式
        return buildTree(preorder, inorder, 0, 0, inorder.length - 1);
    }

    public static void main(String[] args) {
        TreeNode root = buildTree(new int[] {3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        ListUtils.printList(TreeUtils.layerTravel(root));
    }

}
