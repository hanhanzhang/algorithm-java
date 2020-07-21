package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.ListNode;

public class LT0160 {

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) {
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }
        return curA;
    }

    public static void main(String[] args) {

    }
}
