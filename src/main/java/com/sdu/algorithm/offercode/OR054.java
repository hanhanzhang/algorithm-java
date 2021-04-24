package com.sdu.algorithm.offercode;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class OR054 {

    private static int kthLargest(TreeNode root, int k) {
        List<Integer> ret = new ArrayList<>();
        // 中序遍历
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            ret.add(node.val);
            root = node.right;
        }
        return ret.get(ret.size() - k);
    }



    public static void main(String[] args) {
        TreeNode root1 = TreeUtils.buildTree(new Integer[] {3, 1, 4, null, 2});
        System.out.println(kthLargest(root1, 1));

        TreeNode root2 = TreeUtils.buildTree(new Integer[] {5, 3, 6, 2, 4, null, null, 1});
        System.out.println(kthLargest(root2, 3));
    }

}
