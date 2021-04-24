package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LT0142_Unresolved {

  public static class Solution1 {

    private static ListNode detectCycle(ListNode head) {
      // 哈希法(效率低)
      Set<ListNode> nodes = new HashSet<>();
      while (head != null) {
        if (nodes.contains(head)) {
          return head;
        }
        nodes.add(head);
        head = head.next;
      }
      return null;
    }

  }

  public static class Solution2 {

    private static ListNode detectCycle(ListNode head) {
      ListNode slow = head;
      ListNode fast = head;
      do {
        if (slow == null || fast == null || fast.next == null) {
          return null;
        }
        slow = slow.next;
        fast = fast.next.next;
      } while (slow != fast);
      slow = head;
      while (slow != fast) {
        slow = slow.next;
        fast = fast.next;
      }
      return slow;
    }

  }



  public static void main(String[] args) {
    ListNode root = new ListNode(3);

    ListNode node2 = new ListNode(2);
    root.next = node2;

    ListNode node0 = new ListNode(0);
    node2.next = node0;

    ListNode node4 = new ListNode(-4);
    node0.next = node4;
    node4.next = node2;

    System.out.println(Solution2.detectCycle(root));
    System.out.println(Solution1.detectCycle(root));
  }

}
