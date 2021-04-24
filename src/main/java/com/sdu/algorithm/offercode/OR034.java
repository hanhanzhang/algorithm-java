package com.sdu.algorithm.offercode;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class OR034 {

    private static List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) return Collections.emptyList();

        List<List<Integer>> ret = new LinkedList<>();
        if (root.left == null && root.right == null) {
            if (root.val != target) return Collections.emptyList();

            List<Integer> subPath = new LinkedList<>();
            subPath.add(root.val);
            ret.add(subPath);
            return ret;
        }

        List<List<Integer>> leftPath = pathSum(root.left, target - root.val);
        List<List<Integer>> rightPath = pathSum(root.right, target - root.val);
        for (List<Integer> subPath : leftPath) {
            LinkedList<Integer> subPaths = (LinkedList<Integer>) subPath;
            subPaths.addFirst(root.val);
            ret.add(subPath);
        }
        for (List<Integer> subPath : rightPath) {
            LinkedList<Integer> subPaths = (LinkedList<Integer>) subPath;
            subPaths.addFirst(root.val);
            ret.add(subPath);
        }
        return ret;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildTree(new Integer[] {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1});
        List<List<Integer>> paths = pathSum(root, 22);
        System.out.println(paths);
    }

}
