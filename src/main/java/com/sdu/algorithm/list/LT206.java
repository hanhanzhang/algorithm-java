package com.sdu.algorithm.list;

import com.sdu.algorithm.utils.ListNode;

public class LT206 {

  private static ListNode newHead;

  private static ListNode reverse(ListNode head) {
    if (head == null || head.next == null) {
      newHead = head;
      return head;
    }
    ListNode tail = reverse(head.next);
    tail.next = head;
    head.next = null;
    tail = head;
    return tail;
  }

  private static ListNode reverseList(ListNode head) {
    reverse(head);
    return newHead;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);

    ListNode node2 = new ListNode(2);
    head.next = node2;

    ListNode node3 = new ListNode(3);
    node2.next = node3;

    ListNode node4 = new ListNode(4);
    node3.next = node4;

    ListNode node5 = new ListNode(5);
    node4.next = node5;

    reverseList(head);

    while (newHead != null) {
      System.out.println(newHead.val);
      newHead = newHead.next;
    }
  }

}
