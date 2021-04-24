package com.sdu.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LT210 {

  private static void dfs(Map<Integer, Set<Integer>> graph, int start, List<Integer> ans, int[] visited) {
    if (visited[start] == 1) {
      return;
    }
    visited[start] = 1;
    Set<Integer> prerequisites = graph.get(start);
    if (prerequisites == null || prerequisites.isEmpty()) {
      ans.add(start);
      return;
    }

    for (int prerequisite : prerequisites) {
      dfs(graph, prerequisite, ans, visited);
    }
    ans.add(start);
  }

  private static int[] findOrder(int numCourses, int[][] prerequisites) {
    Map<Integer, Set<Integer>> graph = new HashMap<>();
    for (int i = 0; i < prerequisites.length; ++i) {
      int[] prerequisite = prerequisites[i];
      Set<Integer> parents = graph.computeIfAbsent(prerequisite[0], key -> new HashSet<>());
      parents.add(prerequisite[1]);
    }

    List<Integer> ans = new ArrayList<>();
    int[] visited = new int[numCourses];
    for (int course = 0; course < numCourses; ++course) {
      dfs(graph, course, ans, visited);
    }

    return ans.stream().mapToInt(Integer::valueOf).toArray();
  }

  public static void main(String[] args) {
    int[][] prerequisites = new int[][] {
        {1, 0}, {2, 0}, {3, 1}, {3, 2}
    };
    int[] orders = findOrder(4, prerequisites);
    for (int order : orders) {
      System.out.println(order);
    }

    int[][] prerequisites1 = new int[][] {
        {1, 0}, {0, 1}
    };
    int[] orders1 = findOrder(2, prerequisites1);
    for (int order : orders1) {
      System.out.println(order);
    }
  }

}
