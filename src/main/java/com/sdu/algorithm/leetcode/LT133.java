package com.sdu.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LT133 {

  private static class Node {

    public int val;
    public List<Node> neighbors;


    private Node(int val) {
      val = val;
      neighbors = new ArrayList<>();
    }

  }

  private static Node dfs(Node node, Map<Integer, Node> visited) {
    if (node == null) return null;

    // 构建当前节点
    Node cur = new Node(node.val);
    visited.put(node.val, cur);

    // 构建邻居节点
    ArrayList<Node> neighbors = new ArrayList<>();
    for (Node neighbor : node.neighbors) {
      // 若是邻居已经被访问, 则需要将已该节点加入到neighbors中
      if (visited.containsKey(neighbor.val)) {
        neighbors.add(visited.get(neighbor.val));
        continue;
      }
      Node newNeighbor = dfs(neighbor, visited);
      neighbors.add(newNeighbor);
    }
    cur.neighbors = neighbors;

    return cur;
  }

  private static Node cloneGraph(Node node) {
    Map<Integer, Node> visited = new HashMap<>();
    return dfs(node, visited);
  }

  public static void main(String[] args) {

  }

}
