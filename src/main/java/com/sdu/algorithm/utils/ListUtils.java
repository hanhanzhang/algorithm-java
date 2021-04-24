package com.sdu.algorithm.utils;

import java.util.List;

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

  public static void printListNode(ListNode head) {
    if (head == null) {
      return;
    }
    StringBuilder sb = new StringBuilder();
    while (head != null) {
      sb.append(head.val).append(" ");
      head = head.next;
    }
    System.out.println(sb.toString());
  }

  public static <T> void printList(List<T> list) {
    if (list == null) {
      return;
    }
    StringBuilder sb = new StringBuilder();
    for (T obj : list) {
      sb.append(obj).append(" ");
    }
    System.out.println(sb.toString());
  }

}
