package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.TreeNode;

public class LT105 {

  private static TreeNode buildTree(int[] preorder, int index, int[] inorders, int start, int end) {
    if (start > end) return null;

    TreeNode root = new TreeNode(preorder[index]);
    int divideLine = start;
    for (; divideLine < end; ++divideLine) {
      if (inorders[divideLine] == preorder[index]) {
        break;
      }
    }
    // 建立左子树, 中序区间(start, divideLine - 1)
    root.left = buildTree(preorder, index + 1, inorders, start, divideLine - 1);
    // 建立右子树, 中序区间(divideLine + 1, end)
    root.right = buildTree(preorder, index + (divideLine - start + 1), inorders, divideLine + 1, end);
    return root;
  }

  private static TreeNode buildTree(int[] preorder, int[] inorder) {
    return buildTree(preorder, 0, inorder, 0, inorder.length - 1);
  }

  public static void main(String[] args) {
    int[] preorder = new int[] {3, 9, 20, 15, 7};
    int[] inorder = new int[] {9, 3, 15, 20, 7};
    TreeNode root = buildTree(preorder, inorder);
    System.out.println(root.val);
  }

}
