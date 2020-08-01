package com.sdu.algorithm.offercode;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;

public class JZ017 {

  private static boolean hasSubtree(TreeNode root1, TreeNode root2, TreeNode cur) {
    if (cur == null) {
      return true;
    }
    if (root1 == null) {
      return false;
    }
    if (root1.val == cur.val) {
      boolean ans = hasSubtree(root1.left, root2, cur.left)
          && hasSubtree(root1.right, root2, cur.right);
      if (ans) {
        return true;
      }
      return hasSubtree(root1.left, root2, root2)
          || hasSubtree(root1.right, root2, root2);
    }

    return hasSubtree(root1.left, root2, root2)
        || hasSubtree(root1.right, root2, root2);
  }

  private static boolean HasSubtree(TreeNode root1, TreeNode root2) {
    if (root1 == null || root2 == null) {
      return false;
    }
    return hasSubtree(root1, root2, root2);
  }

  public static void main(String[] args) {
    TreeNode root1 = TreeUtils.buildTree(new Integer[]{1, 2, 3, 1, null, null, null, 2, 4});
    TreeNode root2 = TreeUtils.buildTree(new Integer[]{1, 2, 4});
    System.out.print("Result should be true, actual: ");
    System.out.println(HasSubtree(root1, root2));
  }

}
