package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.ListNode;
import com.sdu.algorithm.utils.ListUtils;

public class LT0019 {

  private static ListNode removeNthFromEnd(ListNode head, int n) {
    // 哑巴节点, 预防删除第一个节点
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode first = head, second = dummy;
    for (int i = 0; i < n; ++i) {
      first = first.next;
    }
    while (first != null) {
      first = first.next;
      second = second.next;
    }
    second.next = second.next.next;
    return dummy.next;
  }

  public static void main(String[] args) {
    ListNode head1 = ListUtils.buildListNode(new Integer[] {1, 2, 3, 4, 5});
    ListUtils.printListNode(removeNthFromEnd(head1, 2));

    ListNode head2 = ListUtils.buildListNode(new Integer[] {1});
    ListUtils.printListNode(removeNthFromEnd(head2, 1));
  }

}
