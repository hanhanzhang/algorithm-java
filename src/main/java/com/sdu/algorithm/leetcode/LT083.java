package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.ListNode;
import com.sdu.algorithm.utils.ListUtils;

public class LT083 {

  private static ListNode deleteDuplicates(ListNode head) {
    ListNode cur = head;
    while (cur != null) {
      if (cur.next == null) {
        return head;
      }
      if (cur.val == cur.next.val) {
        cur.next = cur.next.next;
      } else {
        cur = cur.next;
      }
    }
    return head;
  }

  public static void main(String[] args) {
    ListNode head = ListUtils.buildListNode(new Integer[] {1, 1, 2});
    ListNode newHead = deleteDuplicates(head);
    while (newHead != null) {
      System.out.println(newHead.val);
      newHead = newHead.next;
    }

    System.out.println("************");

    ListNode head1 = ListUtils.buildListNode(new Integer[] {1, 1, 2, 3, 3});
    ListNode newHead1 = deleteDuplicates(head1);
    while (newHead1 != null) {
      System.out.println(newHead1.val);
      newHead1 = newHead1.next;
    }
  }

}
