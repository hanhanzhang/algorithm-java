package com.sdu.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LT207 {

  private static boolean dfs(int parent, int course, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
    if (graph == null) return false;
    List<Integer> previousCourses = graph.get(course);
    visited.add(course);
    if (previousCourses == null || previousCourses.isEmpty()) return true;
    // 先学课程中不应该包含parent, 否则返回false
    for (int previousCourse : previousCourses) {
      if (previousCourse == parent) return false;
      if (visited.contains(previousCourse)) {
        continue;
      }
      boolean ans = dfs(parent, previousCourse, graph, visited);
      if (!ans) return false;
    }
    return true;
  }

  private static boolean canFinish(int numCourses, int[][] prerequisites) {
    /*
     * 本质: 判断是否存在环
     * 注意: 本方法实现未暂存中间结果, 可保持中间结果节约计算时间(空间换时间)
     * */
    Map<Integer, List<Integer>> graph = new HashMap<>();
    for (int i = 0; i < prerequisites.length; ++i) {
      int course = prerequisites[i][0];
      int preCourse = prerequisites[i][1];
      List<Integer> previousCourses = graph.computeIfAbsent(course, key -> new ArrayList<>());
      previousCourses.add(preCourse);
    }
    Set<Integer> visited = new HashSet<>();
    for (int i = 0; i < numCourses; ++i) {
      visited.clear();
      boolean ans = dfs(i, i, graph, visited);
      if (!ans) return false;
    }

    return true;
  }

  public static void main(String[] args) {
    int[][] prerequisites1 = new int[][] {{1, 0}, {0, 1}};
    System.out.println(canFinish(2, prerequisites1));

    int[][] prerequisites2 = new int[][] {{1, 0}};
    System.out.println(canFinish(1, prerequisites2));
  }

}
