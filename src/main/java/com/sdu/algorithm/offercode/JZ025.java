package com.sdu.algorithm.offercode;

import com.sdu.algorithm.utils.RandomListNode;
import java.util.HashMap;
import java.util.Map;

public class JZ025 {

  public RandomListNode Clone(RandomListNode pHead) {
    if (pHead == null) {
      return null;
    }
    Map<RandomListNode, RandomListNode> ret = new HashMap<>();
    RandomListNode old = pHead;

    RandomListNode head = new RandomListNode(-1);
    RandomListNode cur = head;

    while (old != null) {
      RandomListNode newNode = new RandomListNode(old.label);
      cur.next = newNode;
      cur = newNode;

      ret.put(old, newNode);
      old = old.next;
    }

    old = pHead;
    while (old != null) {
      if (old.random != null) {
        RandomListNode node = ret.get(old);
        node.random = ret.get(old.random);
      }
      old = old.next;
    }

    return head.next;
  }

  public static void main(String[] args) {

  }

}
