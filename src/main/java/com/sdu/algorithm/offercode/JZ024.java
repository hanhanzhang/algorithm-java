package com.sdu.algorithm.offercode;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;
import java.util.ArrayList;

public class JZ024 {

  private static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
    if (root == null) {
      return null;
    }

    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    if (root.left == null && root.right == null) {
      if (root.val == target) {
        ArrayList<Integer> ret = new ArrayList<>();
        ret.add(root.val);
        ans.add(ret);
        return ans;
      }
      return null;
    }

    // 左子树
    ArrayList<ArrayList<Integer>> left = FindPath(root.left, target - root.val);
    if (left != null && !left.isEmpty()) {
      for (ArrayList<Integer> child : left) {
        child.add(0, root.val);
        ans.add(child);
      }
    }

    // 右子树
    ArrayList<ArrayList<Integer>> right = FindPath(root.right, target - root.val);
    if (right != null && !right.isEmpty()) {
      for (ArrayList<Integer> child : right) {
        child.add(0, root.val);
        ans.add(child);
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    TreeNode root = TreeUtils.buildTree(new Integer[] {1, 2, 2, 3, 3, 3, 4});
    ArrayList<ArrayList<Integer>> ans = FindPath(root, 6);
    System.out.println(ans);
  }

}
