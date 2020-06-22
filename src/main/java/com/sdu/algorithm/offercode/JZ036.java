package com.sdu.algorithm.offercode;

import com.sdu.algorithm.utils.ListNode;

public class JZ036 {

  private static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
    ListNode a = pHead1;
    ListNode b = pHead2;
    while (a != b) {
      a = a != null ? a.next : pHead1;
      b = b != null ? b.next : pHead2;
    }
    return a;
  }

}
