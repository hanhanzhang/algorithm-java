package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.ArrayUtils;

import java.util.Stack;

public class LT0739 {

  private static int[] dailyTemperatures(int[] T) {
    // 单调栈(递减)
    // 对于每个元素, 需要向后找到第一个比当前元素大的值, 故需要先入栈(坐标)
    Stack<Integer> stack = new Stack<>();
    int[] res = new int[T.length];
    for (int i = 0; i < T.length; ++i) {
      while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
        int index = stack.pop();
        res[index] = i - index;
      }
      stack.push(i);
    }

    while (!stack.isEmpty()) {
      res[stack.pop()] = 0;
    }

    return res;
  }

  public static void main(String[] args) {
    ArrayUtils.printArray(dailyTemperatures(new int[] {73, 74, 75, 71, 69, 72, 76, 73}));
  }

}
