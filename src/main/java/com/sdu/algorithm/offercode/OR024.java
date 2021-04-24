package com.sdu.algorithm.offercode;

import com.sdu.algorithm.utils.ListNode;
import com.sdu.algorithm.utils.ListUtils;

public class OR024 {

    // 反转链表
    private static ListNode reverseList(ListNode head) {
        ListNode dumpNode = new ListNode(-1);
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = dumpNode.next;
            dumpNode.next = cur;
            cur = tmp;
        }
        return dumpNode.next;
    }

    public static void main(String[] args) {
        ListNode head = ListUtils.buildListNode(new Integer[] {1, 2, 3, 4, 5});
        ListUtils.printListNode(reverseList(head));
    }

}
