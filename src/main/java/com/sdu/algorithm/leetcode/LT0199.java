package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.ListUtils;
import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LT0199 {

    private static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode cur = queue.poll();
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
                if (i == size - 1) {
                    res.add(cur.val);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildTree(new Integer[] {1, 2, 3, null, 5, null, 4});
        ListUtils.printList(rightSideView(root));
    }

}
