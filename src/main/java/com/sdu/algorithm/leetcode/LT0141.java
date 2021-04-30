package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.ListNode;

public class LT0141 {

  private static boolean hasCycle(ListNode head) {
    ListNode slow = head, fast = head;
    while (true) {
      if (fast == null || fast.next == null) {
        break;
      }
      slow = slow.next;
      fast = fast.next.next;
      if (fast == slow) {
        return true;
      }
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
