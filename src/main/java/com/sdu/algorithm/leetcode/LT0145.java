package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.ListUtils;
import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;

import java.util.*;

public class LT0145 {

    private static List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        // 回溯: 需要记录是否被访问过
        Set<TreeNode> visited = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode top = stack.peek();
            if (top.right == null || visited.contains(top.right)) {
                visited.add(top);
                ans.add(top.val);
                stack.pop();
                root = null;
            } else {
                root = top.right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildTree(new Integer[] {1, null, 2, 3});
        List<Integer> ans = postorderTraversal(root);
        ListUtils.printList(ans);
    }

}
