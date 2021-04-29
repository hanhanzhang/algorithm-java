package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.ListNode;
import com.sdu.algorithm.utils.ListUtils;

import java.util.Stack;

public class LT0234 {

    private static boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        ListNode tail = stack.pop();
        while (head != null) {
            if (head.val != tail.val) return false;
            if (head == tail || head.next == tail) break;
            head = head.next;
            tail = stack.pop();
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(ListUtils.buildListNode(new Integer[] {1})));
        System.out.println(isPalindrome(ListUtils.buildListNode(new Integer[] {1, 2})));
        System.out.println(isPalindrome(ListUtils.buildListNode(new Integer[] {1, 2, 1})));
        System.out.println(isPalindrome(ListUtils.buildListNode(new Integer[] {1, 2, 2, 1})));
        System.out.println(isPalindrome(ListUtils.buildListNode(new Integer[] {1, 1, 2, 1})));
    }

}
