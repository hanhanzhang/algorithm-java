package com.sdu.algorithm.recruitment;

import com.sdu.algorithm.utils.ListNode;
import com.sdu.algorithm.utils.ListUtils;

public class RM0002 {

  private static ListNode newHead;

  private static ListNode reverseInternal(ListNode head) {
    if (head.next == null) {
      newHead = head;
      return head;
    }
    ListNode pre = reverseInternal(head.next);
    pre.next = head;
    return head;
  }

  private static ListNode reverse(ListNode head) {
    if (head == null) {
      return null;
    }
    reverseInternal(head);
    head.next = null;
    return newHead;
  }

  private static ListNode reverse01(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode pre = null;
    while (head.next != null) {
      ListNode temp = head.next;
      head.next = pre;
      pre = head;
      head = temp;
    }

    head.next = pre;
    return head;
  }

  public static void main(String[] args) {
    ListNode head = ListUtils.buildListNode(new Integer[] {1, 2, 3, 4, 5});
    ListNode newHead = reverse(head);
    while (newHead != null) {
      System.out.println(newHead.val);
      newHead = newHead.next;
    }

    System.out.println("**************");

    ListNode head1 = ListUtils.buildListNode(new Integer[] {1, 2, 3, 4, 5});
    ListNode newHead1= reverse01(head1);
    while (newHead1 != null) {
      System.out.println(newHead1.val);
      newHead1 = newHead1.next;
    }
  }

}
