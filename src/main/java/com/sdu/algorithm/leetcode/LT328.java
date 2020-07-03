package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.ListNode;
import com.sdu.algorithm.utils.ListUtils;

public class LT328 {

  private static ListNode oddEvenList(ListNode head) {
    if (head == null) return null;
    ListNode odd = head, even = head.next, evenHead = even;
    while (even != null && even.next != null) {
      odd.next = even.next;
      odd = odd.next;
      even.next = odd.next;
      even = even.next;
    }
    odd.next = evenHead;
    return head;
  }

  public static void main(String[] args) {
    ListNode head = ListUtils.buildListNode(new Integer[] {1, 2, 3, 4, 5});
    ListNode newHead = oddEvenList(head);
    while (newHead != null) {
      System.out.println(newHead.val);
      newHead = newHead.next;
    }
  }

}
