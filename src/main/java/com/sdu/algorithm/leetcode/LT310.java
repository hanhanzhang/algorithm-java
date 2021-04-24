package com.sdu.algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class LT310 {


  private static int bfs(int[][] graph, int vertex) {
    // 遍历记录
    Set<Integer> visited = new HashSet<>();
    Queue<Integer> queue = new ArrayDeque<>();
    queue.offer(vertex);
    visited.add(vertex);
    int height = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int n = 0; n < size; ++n) {
        int v = queue.poll();
        int[] endVertexes = graph[v];
        for (int i = 0; i < endVertexes.length; ++i) {
          if (visited.contains(i) || endVertexes[i] == 0) {
            continue;
          }
          visited.add(i);
          queue.offer(i);
        }
      }
      height += 1;
    }

    return height;
  }

  // 这种算法会超时
  private static List<Integer> findMinHeightTrees(int n, int[][] edges) {
    if (n == 1) {
      return Collections.singletonList(0);
    }
    int[][] graph = new int[n][n];
    for (int i = 0; i < edges.length; ++i) {
      graph[edges[i][0]][edges[i][1]] = 1;
      graph[edges[i][1]][edges[i][0]] = 1;
    }
    int min = Integer.MAX_VALUE;
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < n; ++i) {
      int height = bfs(graph, i);
      if (height < min) {
        min = height;
        result.clear();
        result.add(i);
      } else if (height == min) {
        result.add(i);
      }
    }
    return result;
  }

  /*
   * 既然要求最小高度, 那么从直觉来看, 结点肯定是在最内部的, 越靠近边缘，高度肯定就会越大
   *
   * 这里通过图的度来衡量节点是否靠近边缘
   * */
  private static List<Integer> findMinHeightTrees0(int n, int[][] edges) {
    if (n == 1) {
      return Collections.singletonList(0);
    }
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; ++i) {
      graph.add(new ArrayList<>());
    }
    int[] degree = new int[n];
    for (int i = 0; i < edges.length; ++i) {
      int sv = edges[i][0];
      int ev = edges[i][1];
      graph.get(sv).add(ev);
      graph.get(ev).add(sv);
      degree[sv] += 1;
      degree[ev] += 1;
    }

    // 度为1的节点进入队列, 度为1要连通到其他节点的树的高度肯定是最大, 应该要放弃
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < n; ++i) {
      if (degree[i] == 1) {
        queue.offer(i);
      }
    }

    List<Integer> minHeightTreeRoots = new ArrayList<>();
    while (!queue.isEmpty()) {
      int size = queue.size();
      minHeightTreeRoots.clear();
      for (int i = 0; i < size; ++i) {
        int v = queue.poll();
        minHeightTreeRoots.add(v);
        List<Integer> endVertexes = graph.get(v);
        for (int ev : endVertexes) {
          if (--degree[ev] == 1) {
            queue.offer(ev);
          }
        }
      }
    }

    return minHeightTreeRoots;
  }


  public static void main(String[] args) {
    int[][] edges = new int[][] {
        {0, 3},
        {1, 3},
        {2, 3},
        {4, 3},
        {5, 4}
    };

    System.out.println(findMinHeightTrees0(6, edges));
  }

}
