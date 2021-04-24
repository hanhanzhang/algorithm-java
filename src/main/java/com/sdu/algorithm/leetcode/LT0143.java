package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.ListNode;
import com.sdu.algorithm.utils.ListUtils;

import java.util.Stack;

public class LT0143 {

    private static void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        ListNode ret = head, tail = stack.pop();
        while (ret != null) {
            if (ret.next == tail || ret == tail) {
                break;
            }
            ListNode ops = ret.next;
            ret.next = tail;
            tail.next = ops;
            ret = ops;
            tail = stack.pop();
        }
        tail.next = null;
    }

    public static void main(String[] args) {
        ListNode head1 = ListUtils.buildListNode(new Integer[] {1, 2, 3, 4});
        reorderList(head1);
        ListUtils.printListNode(head1);

        ListNode head2 = ListUtils.buildListNode(new Integer[] {1, 2, 3, 4, 5});
        reorderList(head2);
        ListUtils.printListNode(head2);
    }

}
