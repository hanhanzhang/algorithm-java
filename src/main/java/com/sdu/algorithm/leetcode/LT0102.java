package com.sdu.algorithm.leetcode;


import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;

import java.util.*;

public class LT0102 {

    private static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        List<List<Integer>> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            List<Integer> ret = new ArrayList<>();
            for (int i = 0; i < cnt; ++i) {
                TreeNode cur = queue.poll();
                ret.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            ans.add(ret);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildTree(new Integer[] {3, 9, 20, null, null, 15, 7});
        List<List<Integer>> ans = levelOrder(root);
        System.out.println(ans.size());
    }
}
