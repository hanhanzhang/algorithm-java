package com.sdu.algorithm.offercode;

import com.sdu.algorithm.utils.TreeLinkNode;

public class JZ057 {

  private static TreeLinkNode GetNext(TreeLinkNode pNode) {
    if (pNode == null) {
      return null;
    }
    if (pNode.right != null) {
      pNode = pNode.right;
      // 左子树不空, 下个节点在左子树中
      while (pNode.left != null) {
        pNode = pNode.left;
      }
      return pNode;
    }

    while (pNode.next != null) {
      if (pNode.next.left == pNode) {
        return pNode.next;
      }
      pNode = pNode.next;
    }

    return pNode;
  }

  public static void main(String[] args) {
    TreeLinkNode root = new TreeLinkNode(1);

    TreeLinkNode node2 = new TreeLinkNode(2);
    TreeLinkNode node3 = new TreeLinkNode(3);

    root.left = node2;
    root.right = node3;
    node2.next = root;
    node3.next = root;

    TreeLinkNode node4 = new TreeLinkNode(4);
    TreeLinkNode node5 = new TreeLinkNode(5);

    node2.left = node4;
    node2.right = node5;
    node4.next = node2;
    node5.next = node2;

    System.out.println(GetNext(node2).val);
  }

}
