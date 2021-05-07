package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.ListNode;
import com.sdu.algorithm.utils.ListUtils;

public class LT0002 {

  private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dumpNode = new ListNode(0);
    ListNode cur = dumpNode;
    int carry = 0;
    while (l1 != null || l2 != null || carry != 0) {
      int x = l1 != null ? l1.val : 0;
      int y = l2 != null ? l2.val : 0;
      int sum = x + y + carry;
      carry = sum / 10;
      ListNode node = new ListNode(sum % 10);
      cur.next = node;
      cur = node;

      l1 = l1 != null ? l1.next : null;
      l2 = l2 != null ? l2.next : null;
    }

    return dumpNode.next;
  }

  public static void main(String[] args) {
    ListNode l1 = ListUtils.buildListNode(new Integer[] {2, 4, 3});
    ListNode l2 = ListUtils.buildListNode(new Integer[] {5, 6, 4});

    ListNode head = addTwoNumbers(l1, l2);

    while (head != null) {
      System.out.print(head.val);
      head = head.next;
    }
  }

}
