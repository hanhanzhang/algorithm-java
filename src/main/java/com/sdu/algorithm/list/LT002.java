package com.sdu.algorithm.list;

import com.sdu.algorithm.utils.ListNode;

public class LT002 {

  private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode root = null;
    ListNode cur = null;
    int carry = 0;
    while (l1 != null || l2 != null) {
      int x = l1 != null ? l1.val : 0;
      int y = l2 != null ? l2.val : 0;
      int sum = x + y + carry;

      // 算商
      carry = sum / 10;
      // 算余数
      ListNode node = new ListNode(sum % 10);

      if (root == null) {
        root = node;
        cur = node;
      } else {
        cur.next = node;
        cur = node;
      }

      l1 = l1 != null ? l1.next : null;
      l2 = l2 != null ? l2.next : null;
    }

    if (carry > 0) {
      cur.next = new ListNode(carry);
    }

    return root;
  }

  public static void main(String[] args) {
    ListNode l1 = new ListNode(2);
    l1.next = new ListNode(4);
    l1.next.next = new ListNode(3);

    ListNode l2 = new ListNode(5);
    l2.next = new ListNode(6);
    l2.next.next = new ListNode(4);

    ListNode node = addTwoNumbers(l1, l2);

    while (node != null) {
      System.out.print(node.val);
      node = node.next;
    }
  }

}
