package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.ListNode;
import com.sdu.algorithm.utils.ListUtils;
import java.util.Stack;

public class LT445 {

  private static ListNode addTwoNumbers(ListNode n1, ListNode n2) {
    if (n1 == null || n2 == null) {
      return n1 == null ? n2 : n1;
    }

    //
    Stack<ListNode> s1 = new Stack<>();
    Stack<ListNode> s2 = new Stack<>();
    while (n1 != null) {
      s1.add(n1);
      n1 = n1.next;
    }
    while (n2 != null) {
      s2.add(n2);
      n2 = n2.next;
    }

    // 进位
    int carry = 0;
    ListNode head = new ListNode(-1);
    while (!s1.isEmpty() && !s2.isEmpty()) {
      int sum = s1.pop().val + s2.pop().val + carry;
      carry = sum / 10;
      ListNode node = new ListNode(sum % 10);
      ListNode temp = head.next;
      head.next = node;
      node.next = temp;
    }

    Stack<ListNode> remain = s1.isEmpty() ? s2 : s1;
    while (!remain.isEmpty()) {
      int sum = remain.pop().val + carry;
      carry = sum / 10;
      ListNode node = new ListNode(sum % 10);
      ListNode temp = head.next;
      head.next = node;
      node.next = temp;
    }

    if (carry != 0) {
      ListNode node = new ListNode(carry);
      ListNode temp = head.next;
      head.next = node;
      node.next = temp;
    }

    return head.next;
  }

  public static void main(String[] args) {
    ListNode n1 = ListUtils.buildListNode(new Integer[] {7, 2, 4, 3});
    ListNode n2 = ListUtils.buildListNode(new Integer[] {5, 6, 4});

    ListNode head = addTwoNumbers(n1, n2);
    while (head != null) {
      System.out.println(head.val);
      head = head.next;
    }
  }

}
