package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.ListNode;
import com.sdu.algorithm.utils.ListUtils;

public class LT0234_1 {

    private static ListNode frontPointer;

    private static boolean recursivelyCheck(ListNode current) {
        if (current == null) return true;
        if (!recursivelyCheck(current.next) || current.val != frontPointer.val) {
            return false;
        }
        frontPointer = frontPointer.next;
        return true;
    }

    private static boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(ListUtils.buildListNode(new Integer[] {1})));
        System.out.println(isPalindrome(ListUtils.buildListNode(new Integer[] {1, 2})));
        System.out.println(isPalindrome(ListUtils.buildListNode(new Integer[] {1, 2, 1})));
        System.out.println(isPalindrome(ListUtils.buildListNode(new Integer[] {1, 2, 2, 1})));
        System.out.println(isPalindrome(ListUtils.buildListNode(new Integer[] {1, 1, 2, 1})));
    }

}
