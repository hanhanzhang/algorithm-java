package com.sdu.algorithm.offercode;

import com.sdu.algorithm.utils.ListNode;
import com.sdu.algorithm.utils.ListUtils;

public class JZ014 {

  private static ListNode FindKthToTail(ListNode head, int k) {
    if (head == null) {
      return null;
    }
    ListNode p1 = head, p2 = head;
    for (int i = 0; i < k; ++i) {
      if (p1 == null) {
        return null;
      }
      p1 = p1.next;
    }

    while (p1 != null) {
      p2 = p2.next;
      p1 = p1.next;
    }

    return p2;
  }

  public static void main(String[] args) {
    ListNode head = ListUtils.buildListNode(new Integer[] {1, 2, 3, 4, 5});
    System.out.println(FindKthToTail(head, 2));
    System.out.println(FindKthToTail(head, 3));
    System.out.println(FindKthToTail(head, 6));
    System.out.println(FindKthToTail(head, 4));

  }

}
