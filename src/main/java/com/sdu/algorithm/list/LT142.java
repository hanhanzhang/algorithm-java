package com.sdu.algorithm.list;

import com.sdu.algorithm.utils.ListNode;

public class LT142 {

  private static ListNode detectCycle(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }

    // 快慢指针
    ListNode low = head.next, quick = head.next.next;
    while (low != quick) {
      if (low == null || quick == null || quick.next == null) {
        return null;
      }
      low = low.next;
      quick = quick.next.next;
    }

    //
    quick = head;
    while (quick != low) {
      quick = quick.next;
      low = low.next;
    }
    return quick;
  }

  public static void main(String[] args) {
    ListNode root = new ListNode(3);

    ListNode node2 = new ListNode(2);
    root.next = node2;

    ListNode node0 = new ListNode(0);
    node2.next = node0;

    ListNode node4 = new ListNode(-4);
    node0.next = node4;
    node4.next = node2;

    System.out.println(detectCycle(root));
  }

}
