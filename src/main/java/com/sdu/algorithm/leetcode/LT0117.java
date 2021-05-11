package com.sdu.algorithm.leetcode;


import java.util.ArrayDeque;
import java.util.Queue;

public class LT0117 {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    };

    public static Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node pre = null;
            for (int i = 0; i < size; ++i) {
                Node node = queue.poll();
                if (pre == null) {
                    pre = node;
                } else {
                    pre.next = node;
                    pre = node;
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {

    }

}
