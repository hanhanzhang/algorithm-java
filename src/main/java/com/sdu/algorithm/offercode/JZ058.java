package com.sdu.algorithm.offercode;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;

public class JZ058 {

  private static boolean isSymmetrical(TreeNode root1, TreeNode root2) {
    if(root1 == null && root2 == null) {
      return true;
    }
    if(root1 != null && root2 != null) {
      if(root1.val == root2.val) {
        return isSymmetrical(root1.left, root2.right)
            && isSymmetrical(root1.right, root2.left);
      }
      return false;
    }
    return false;
  }

  private static boolean isSymmetrical(TreeNode pRoot) {
    if (pRoot == null) {
      return true;
    }
    return isSymmetrical(pRoot.left, pRoot.right);
  }

  public static void main(String[] args) {
    TreeNode root = TreeUtils.buildTree(new Integer[] {1, 2, 2, 4, 5, 5, 4});
    System.out.println(isSymmetrical(root));
  }

}
