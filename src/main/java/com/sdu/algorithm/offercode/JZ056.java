package com.sdu.algorithm.offercode;

import com.sdu.algorithm.utils.ListNode;
import com.sdu.algorithm.utils.ListUtils;

public class JZ056 {

  private static ListNode deleteDuplication(ListNode pHead) {
    if (pHead == null) {
      return null;
    }
    ListNode newHead = pHead;

    ListNode cur = pHead.next;
    ListNode pre = pHead;
    while (cur != null) {
      int val = cur.val;
      if (cur.next == null) {
        if (cur.val == pre.val) {
          return null;
        }
        break;
      }
      if (val == cur.next.val) {
        while (cur != null && cur.val == val) {
          cur = cur.next;
        }
        if (cur == null) {
          if (pre.val == val) {
            return null;
          }
          pre.next = null;
          return newHead;
        }
        if (pre.val == val) {
          newHead = cur;
          pre = newHead;
          cur = cur.next;
        } else {
          pre.next = cur;
        }
      } else {
        if (pre.val == cur.val) {
          newHead = cur.next;
          pre = newHead;
          cur = newHead.next;
        } else {
          pre = pre.next;
          cur = cur.next;
        }
      }
    }

    return newHead;
  }

  public static void main(String[] args) {
    ListNode head = ListUtils.buildListNode(new Integer[] {1, 2, 3, 3, 4, 4, 5});
    ListNode newHead = deleteDuplication(head);
    while (newHead != null) {
      System.out.println(newHead.val);
      newHead = newHead.next;
    }

    System.out.println("============");

    ListNode head1 = ListUtils.buildListNode(new Integer[] {1, 1, 1, 1, 1, 1, 2});
    ListNode newHead1 = deleteDuplication(head1);
    while (newHead1 != null) {
      System.out.println(newHead1.val);
      newHead1 = newHead1.next;
    }

    System.out.println("============");

    ListNode head2 = ListUtils.buildListNode(new Integer[] {1, 1, 2, 2, 3, 3, 4, 4});
    ListNode newHead2 = deleteDuplication(head2);
    while (newHead2 != null) {
      System.out.println(newHead2.val);
      newHead2 = newHead2.next;
    }
  }

}
