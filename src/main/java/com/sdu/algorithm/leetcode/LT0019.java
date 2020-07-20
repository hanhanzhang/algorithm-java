package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.ListNode;
import com.sdu.algorithm.utils.ListUtils;

public class LT0019 {

  // 递归方式
  private static Object[] removeNth(ListNode head, int n) {
    if (head == null) {
      return new Object[] {null, 0};
    }
    Object[] r = removeNth(head.next, n);
    int nth = (int) r[1] + 1;
    if (nth == n) {
      // cur节点应被删除, 故不返回当前节点
      return new Object[] {r[0], nth};
    } else {
      head.next = (ListNode) r[0];
      return new Object[] {head, nth};
    }
  }

  private static ListNode removeNthFromEnd(ListNode head, int n) {
    return (ListNode) removeNth(head, n)[0];
  }

  // 双指针方法
  private static ListNode removeNthFromEnd0(ListNode head, int n) {

    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode first = dummy;
    ListNode second = dummy;
    for (int i = 0; i <= n; ++i) {
      first = first.next;
    }
    while (first != null) {
      second = second.next;
      first = first.next;
    }
    // 删除first的下一个节点
    second.next = second.next.next;

    return dummy.next;
  }

  public static void main(String[] args) {
    ListNode head = ListUtils.buildListNode(new Integer[] {1, 2, 3, 4, 5});

    ListNode newHead = removeNthFromEnd0(head, 5);

    while (newHead != null) {
      System.out.println(newHead.val);
      newHead = newHead.next;
    }
  }

}
