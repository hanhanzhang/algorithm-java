package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.ListNode;

public class LT141 {

  private static boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }

    // 快慢指针
    ListNode low = head.next, quick = head.next.next;

    while (low != null && quick != null) {
      if (low == quick) {
        return true;
      }
      if (quick.next == null) {
        return false;
      }
      quick = quick.next.next;
      low = low.next;
    }

    return false;
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

    System.out.println(hasCycle(root));
  }

}
