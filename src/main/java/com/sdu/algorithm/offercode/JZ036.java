package com.sdu.algorithm.offercode;

import com.sdu.algorithm.utils.ListNode;
import com.sdu.algorithm.utils.ListUtils;

public class JZ036 {

  private static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
    ListNode a = pHead1;
    ListNode b = pHead2;
    // 求链表长度算公共节点, 没有本质的区别
    while (a != b) {
      a = a != null ? a.next : pHead1;
      b = b != null ? b.next : pHead2;
    }
    return a;
  }

  public static void main(String[] args) {
    ListNode common = ListUtils.buildListNode(new Integer[] {5, 6, 7});
    ListNode n1 = ListUtils.buildListNode(new Integer[] {1, 2, 3, 4});
    ListNode n2 = ListUtils.buildListNode(new Integer[] {1, 2});

    //
    ListNode cur = n1;
    while (cur.next != null) {
      cur = cur.next;
    }
    cur.next = common;

    cur = n2;

    while (cur.next != null) {
      cur = cur.next;
    }
    cur.next = common;
    System.out.println(FindFirstCommonNode(n1, n2).val);

  }

}
