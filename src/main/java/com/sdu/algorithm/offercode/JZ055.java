package com.sdu.algorithm.offercode;

import com.sdu.algorithm.utils.ListNode;

public class JZ055 {

  private static ListNode EntryNodeOfLoop(ListNode pHead) {
    if (pHead == null) {
      return null;
    }
    ListNode slow = pHead;
    ListNode fast = pHead;

    do {
      slow = slow.next;
      if (fast.next == null) {
        return null;
      }
      fast = fast.next.next;
    } while (slow != fast);

    slow = pHead;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }

    return slow;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);

    ListNode node2 = new ListNode(2);
    head.next = node2;

    ListNode node3 = new ListNode(3);
    node2.next = node3;

    ListNode node4 = new ListNode(4);
    node3.next = node4;

    node4.next = node2;

    System.out.println(EntryNodeOfLoop(head).val);

  }

}
