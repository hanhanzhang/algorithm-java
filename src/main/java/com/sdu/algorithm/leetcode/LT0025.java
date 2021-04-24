package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.ListNode;
import com.sdu.algorithm.utils.ListUtils;

public class LT0025 {

  private static ListNode[] reverseKGroup(ListNode head, int k, int len) {
    if (head == null) {
      return null;
    }
    ListNode tail = head;
    if (len < k) {
      while (tail.next != null) {
        tail = tail.next;
      }
      return new ListNode[] {head, tail};
    }

    ListNode pre = null;
    for (int i = 0; i < k; ++i) {
      ListNode temp = head.next;
      head.next = pre;
      pre = head;
      head = temp;
    }

    ListNode[] ans = reverseKGroup(head, k, len - k);
    if (ans == null) {
      return new ListNode[] {pre, tail};
    }

    tail.next = ans[0];

    return new ListNode[] {pre, ans[1]};
  }

  private static ListNode reverseKGroup(ListNode head, int k) {
    if (head == null) {
      return null;
    }
    ListNode cur = head;
    int len = 0;
    while (cur != null) {
      cur = cur.next;
      len += 1;
    }

    ListNode[] ans = reverseKGroup(head, k, len);
    return ans[0];
  }

  public static void main(String[] args) {
    ListNode head = ListUtils.buildListNode(new Integer[] {1, 2, 3, 4, 5});

    ListNode newHead = reverseKGroup(head, 2);
    while (newHead != null) {
      System.out.println(newHead.val);
      newHead = newHead.next;
    }

    System.out.println("**********");

    ListNode head1 = ListUtils.buildListNode(new Integer[] {1, 2, 3, 4, 5});
    ListNode newHead2 = reverseKGroup(head1, 3);
    while (newHead2 != null) {
      System.out.println(newHead2.val);
      newHead2 = newHead2.next;
    }

    System.out.println("**********");

    ListNode head2 = ListUtils.buildListNode(new Integer[] {1, 2, 3, 4, 5});
    ListNode newHead3 = reverseKGroup(head2, 5);
    while (newHead3 != null) {
      System.out.println(newHead3.val);
      newHead3 = newHead3.next;
    }
  }

}
