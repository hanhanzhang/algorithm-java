package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.ListUtils;
import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LT0113 {

    private static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                LinkedList<Integer> ret = new LinkedList<>();
                ret.add(root.val);
                ans.add(ret);
            }
            return ans;
        }
        List<List<Integer>> leftPaths = pathSum(root.left, targetSum - root.val);
        List<List<Integer>> rightPaths = pathSum(root.right, targetSum - root.val);
        for (List<Integer> leftPath : leftPaths) {
            ((LinkedList<Integer>)leftPath).addFirst(root.val);
            ans.add(leftPath);
        }
        for (List<Integer> rightPath : rightPaths) {
            ((LinkedList<Integer>)rightPath).addFirst(root.val);
            ans.add(rightPath);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root1 = TreeUtils.buildTree(new Integer[] {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1});
        ListUtils.printList(pathSum(root1, 22));

        TreeNode root2 = TreeUtils.buildTree(new Integer[] {1, 2, 3});
        ListUtils.printList(pathSum(root2, 5));
    }

}
