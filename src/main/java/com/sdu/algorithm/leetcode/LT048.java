package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.ListNode;

public class LT048 {

  private static ListNode sortList01(ListNode head) {
    // TODO: 归并排序
    return null;
  }

  private static ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode h = head, tail = head, cur = head.next;
    while (cur != null) {
      if (tail.val <= cur.val) {
        tail = cur;
        cur = cur.next;
      } else if (cur.val <= h.val){
        tail.next = cur.next;
        cur.next = h;
        h = cur;
        cur = tail.next;
      } else {
        // 调整顺序:(h, tail)
        ListNode p = h;
        while (p.next != null) {
          if (cur.val >= p.val && cur.val <= p.next.val) {
            // tail
            tail.next = cur.next;
            cur.next = p.next;
            p.next = cur;
            cur = tail.next;
            break;
          }
          p = p.next;
        }
      }
    }
    return h;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(4);

    ListNode node2 = new ListNode(2);
    head.next = node2;

    ListNode node1 = new ListNode(1);
    node2.next = node1;

    ListNode node3 = new ListNode(3);
    node1.next = node3;

    ListNode h = sortList(head);
    while (h != null) {
      System.out.println(h.val);
      h = h.next;
    }
  }

}
