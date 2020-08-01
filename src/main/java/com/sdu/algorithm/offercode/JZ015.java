package com.sdu.algorithm.offercode;

import com.sdu.algorithm.utils.ListNode;
import com.sdu.algorithm.utils.ListUtils;

public class JZ015 {

  public static class Solution1 {

    private static ListNode[] reverseList(ListNode head, ListNode cur) {
      if (cur.next == null) {
        return new ListNode[] {cur, cur};
      }
      ListNode[] ret = reverseList(head, cur.next);
      ret[1].next = cur;
      ret[1] = cur;
      if (cur == head) {
        cur.next = null;
      }
      return ret;
    }

    public static ListNode reverseList(ListNode head) {
      if (head == null) {
        return null;
      }
      return reverseList(head, head)[0];
    }

  }

  public static class Solution2 {

    public static ListNode reverseList(ListNode head) {
      // 哑巴节点
      ListNode dumpNode = new ListNode(0);
      while (head != null) {
        ListNode temp = head.next;
        head.next = dumpNode.next;
        dumpNode.next = head;
        head = temp;
      }
      return dumpNode.next;
    }

  }

  public static void main(String[] args) {
    ListNode head = ListUtils.buildListNode(new Integer[] {1, 2, 3, 4, 5});
    ListNode newHead = Solution1.reverseList(head);

    while (newHead != null) {
      System.out.println(newHead.val);
      newHead = newHead.next;
    }

    System.out.println("**********");

    ListNode head1 = ListUtils.buildListNode(new Integer[] {1, 2, 3, 4, 5});
    ListNode newHead1 = Solution2.reverseList(head1);
    while (newHead1 != null) {
      System.out.println(newHead1.val);
      newHead1 = newHead1.next;
    }
  }

}
