package com.sdu.algorithm.offercode;

import com.sdu.algorithm.utils.ListNode;
import com.sdu.algorithm.utils.ListUtils;

public class JZ016 {

  private static ListNode Merge(ListNode list1,ListNode list2) {
    // 虚拟节点
    ListNode head = new ListNode(-1);
    ListNode cur = head;
    while (list1 != null && list2 != null) {
      if (list1.val <= list2.val) {
        cur.next = list1;
        list1 = list1.next;
      } else {
        cur.next = list2;
        list2 = list2.next;
      }
      cur = cur.next;
    }
    cur.next = list1 != null ? list1 : list2;

    return head.next;
  }

  public static void main(String[] args) {
    ListNode list1 = ListUtils.buildListNode(new Integer[] {1, 3, 5});
    ListNode list2 = ListUtils.buildListNode(new Integer[] {2, 4, 6, 5, 8});
    ListNode head = Merge(list1, list2);

    while (head != null) {
      System.out.println(head.val);
      head = head.next;
    }
  }

}
