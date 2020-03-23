package com.sdu.algorithm.utils;

public class ListUtils {

  public static ListNode buildListNode(Integer[] nodes) {
    if (nodes == null || nodes.length == 0) {
      return null;
    }
    ListNode head = new ListNode(nodes[0]);
    ListNode cur = head;
    for (int i = 1; i < nodes.length; ++i) {
      ListNode node = new ListNode(nodes[i]);
      cur.next = node;
      cur = node;
    }

    return head;
  }

}
