package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.ListNode;

public class LT0142 {

    private static ListNode detectCycle(ListNode head) {
        //              D
        //         +----+----+
        //         |         |
        // +-------+---------+
        // A       B
        // 相遇点: D, 则 2(AB + BD) = AB + BD + DB + BD
        // 可得出: AB = DB
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
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

        System.out.println(detectCycle(root));
    }

}
