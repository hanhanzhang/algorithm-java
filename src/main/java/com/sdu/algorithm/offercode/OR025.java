package com.sdu.algorithm.offercode;

import com.sdu.algorithm.utils.ListNode;
import com.sdu.algorithm.utils.ListUtils;

public class OR025 {

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dumpNode = new ListNode(-1);
        ListNode cur = dumpNode;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    cur.next = l1;
                    cur = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    cur = l2;
                    l2 = l2.next;
                }
            } else if (l1 == null) {
                cur.next = l2;
                cur = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                cur = l1;
                l1 = l1.next;
            }
        }

        return dumpNode.next;
    }

    public static void main(String[] args) {
        ListNode h1 = ListUtils.buildListNode(new Integer[] {1, 2, 4});
        ListNode h2 = ListUtils.buildListNode(new Integer[] {1, 3, 4});
        ListUtils.printListNode(mergeTwoLists(h1, h2));
    }
}
