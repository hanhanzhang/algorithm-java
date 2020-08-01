package com.sdu.algorithm.offercode;

import com.sdu.algorithm.utils.TreeNode;

public class JZ004 {

  /**
   * @param ps 前序序列开始
   * @param pe 前序序列结束
   * @param is 中序序列开始
   * @param ie 中序序列结束
   * */
  private static TreeNode buildTree(int[] pre, int[] in, int ps, int pe, int is, int ie) {
    if (ps > pe || is > ie) {
      return null;
    }
    TreeNode root = new TreeNode(pre[ps]);
    int pos = is;
    for (; pos <= ie; ++pos) {
      if (in[pos] == pre[ps]) {
        break;
      }
    }
    int leftLen = pos - is;
    // 构建左子树
    root.left = buildTree(pre, in, ps + 1, ps + leftLen, is, pos - 1);
    root.right = buildTree(pre, in, ps + leftLen + 1, pe, pos + 1, ie);
    return root;
  }

  private static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
    return buildTree(pre, in, 0, pre.length - 1, 0, in.length - 1);
  }

  public static void main(String[] args) {
    int[] pre = new int[] {1, 2, 4, 7, 3, 5, 6, 8};
    int[] in = new int[] {4, 7, 2, 1, 5, 3, 8, 6};

    TreeNode root = reConstructBinaryTree(pre, in);

    System.out.println(root.val);
  }

}
