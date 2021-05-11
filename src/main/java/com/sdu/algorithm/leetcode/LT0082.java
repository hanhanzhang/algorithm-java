package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.ListNode;
import com.sdu.algorithm.utils.ListUtils;

public class LT0082 {

    private static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        // 哨兵
        ListNode dumpNode = new ListNode(-1);
        ListNode cur = dumpNode;
        ListNode slow = head, fast = head.next;
        while (fast != null) {
            while (fast != null && fast.val == slow.val) fast = fast.next;
            if (slow.next == fast) {
                cur.next = slow;
                cur = slow;
            }
            slow = fast;
            fast = fast != null ? fast.next : null;
        }
        cur.next = slow;
        return dumpNode.next;
    }

    public static void main(String[] args) {
        ListNode head1 = ListUtils.buildListNode(new Integer[] {1, 2, 3, 3, 4, 4, 5});
        ListUtils.printListNode(deleteDuplicates(head1));

        ListNode head2 = ListUtils.buildListNode(new Integer[] {1, 1, 1, 2, 3});
        ListUtils.printListNode(deleteDuplicates(head2));

        ListNode head3 = ListUtils.buildListNode(new Integer[] {1, 1});
        ListUtils.printListNode(deleteDuplicates(head3));
    }
}
