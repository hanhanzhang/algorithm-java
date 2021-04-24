package com.sdu.algorithm.offercode;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;

import java.util.Stack;

public class OR054_1 {

    private static int kthLargest(TreeNode root, int k) {
        // 右 -> 中 -> 左: 从大到小
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.right;
            }
            TreeNode cur = stack.pop();
            if (--k == 0) {
                return cur.val;
            }
            root = cur.left;
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeNode root1 = TreeUtils.buildTree(new Integer[] {3, 1, 4, null, 2});
        System.out.println(kthLargest(root1, 1));

        TreeNode root2 = TreeUtils.buildTree(new Integer[] {5, 3, 6, 2, 4, null, null, 1});
        System.out.println(kthLargest(root2, 3));
    }

}
