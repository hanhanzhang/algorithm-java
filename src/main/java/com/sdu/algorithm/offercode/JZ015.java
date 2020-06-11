package com.sdu.algorithm.offercode;

import com.sdu.algorithm.utils.ListNode;
import com.sdu.algorithm.utils.ListUtils;

public class JZ015 {

  private static ListNode newHead;

  private static ListNode reverseList(ListNode head) {
    if (head.next == null) {
      newHead = head;
      return head;
    }
    ListNode ans = reverseList(head.next);
    ans.next = head;
    return head;
  }

  private static ListNode ReverseList(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode node = reverseList(head);
    node.next = null;
    return newHead;
  }

  public static void main(String[] args) {
    ListNode head = ListUtils.buildListNode(new Integer[] {1, 2, 3, 4, 5});
    ListNode newHead = ReverseList(head);

    while (newHead != null) {
      System.out.println(newHead.val);
      newHead = newHead.next;
    }
  }

}
