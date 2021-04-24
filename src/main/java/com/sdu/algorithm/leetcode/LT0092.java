package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.ListNode;
import com.sdu.algorithm.utils.ListUtils;

public class LT0092 {

    private static ListNode reverseBetween(ListNode head, int left, int right) {
        // 头节点有可能发生变化(若left=1, 则头部节点发生变化),使用虚拟头节点可以避免复杂的分类讨论
        ListNode dumpNode = new ListNode(-1);
        dumpNode.next = head;
        ListNode pre = dumpNode;
        for (int i = 0; i < left - 1; ++i) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode reverseHead = cur;
        // 反转列表
        for (int i = left; i < right && cur.next != null; ++i) {
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = reverseHead;
            reverseHead = tmp;
        }
        pre.next = reverseHead;
        return dumpNode.next;
    }

    public static void main(String[] args) {
        ListNode head = ListUtils.buildListNode(new Integer[] {1, 2, 3, 4, 5});
        ListNode newHead = reverseBetween(head, 2, 4);
        ListUtils.printListNode(newHead);
    }

}
