package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LT0142II {

    private static ListNode detectCycle(ListNode head) {
        // 哈希: 第一次访问过即入环口
        Set<ListNode> visited = new HashSet<>();
        while (head != null) {
            if (visited.contains(head)) {
                return head;
            }
            visited.add(head);
            head = head.next;
        }
        return null;
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
