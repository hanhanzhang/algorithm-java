package com.sdu.algorithm.offercode;

import com.sdu.algorithm.utils.ListNode;
import com.sdu.algorithm.utils.ListUtils;
import java.util.ArrayList;

public class JZ003 {

  private static void dfs(ListNode listNode, ArrayList<Integer> ans) {
    if (listNode == null) {
      return;
    }
    dfs(listNode.next, ans);
    ans.add(listNode.val);
  }

  private static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    ArrayList<Integer> ans = new ArrayList<>();
    dfs(listNode, ans);
    return ans;
  }

  public static void main(String[] args) {
    ListNode head = ListUtils.buildListNode(new Integer[] {1, 2, 3, 4, 5, 6});
    ArrayList<Integer> ans = printListFromTailToHead(head);
    System.out.println(ans);
  }

}
