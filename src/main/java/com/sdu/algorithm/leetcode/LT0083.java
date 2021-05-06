package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.ListNode;
import com.sdu.algorithm.utils.ListUtils;

public class LT0083 {

  private static ListNode deleteDuplicates(ListNode head) {
    if (head == null) return null;
    // 双指针
    ListNode slow = head, fast = head.next;
    while (fast != null) {
      if (fast.val == slow.val) {
        fast = fast.next;
        slow.next = fast;
      } else {
        slow = fast;
        fast = fast.next;
      }
    }
    return head;
  }

  public static void main(String[] args) {
    ListNode head = ListUtils.buildListNode(new Integer[] {1, 1, 2});
    ListUtils.printListNode(deleteDuplicates(head));

    ListNode head1 = ListUtils.buildListNode(new Integer[] {1, 1, 2, 3, 3});
    ListUtils.printListNode(deleteDuplicates(head1));
  }

}
