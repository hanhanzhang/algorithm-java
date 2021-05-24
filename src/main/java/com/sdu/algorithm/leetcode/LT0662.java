package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;

import java.util.Deque;
import java.util.LinkedList;

public class LT0662 {

    private static int widthOfBinaryTree(TreeNode root) {
        // val: 表示下标
        if (root == null) return 0;
        root.val = 1;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxWidth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            maxWidth = Math.max(maxWidth, queue.peekLast().val - queue.peekFirst().val + 1);
            for (int i = 0; i < size; ++i) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    cur.left.val = cur.val * 2 - 1;
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    cur.right.val = cur.val * 2;
                    queue.offer(cur.right);
                }
            }
        }
        return maxWidth;
    }

    public static void main(String[] args) {
        TreeNode root1 = TreeUtils.buildTree(new Integer[] {1, 3, 2, 5, 3, null, 9});
        System.out.println(widthOfBinaryTree(root1));

        TreeNode root2 = TreeUtils.buildTree(new Integer[] {1, 3, 2, 5, null, null, 9, 6, null, null, 7});
        System.out.println(widthOfBinaryTree(root2));
    }

}
