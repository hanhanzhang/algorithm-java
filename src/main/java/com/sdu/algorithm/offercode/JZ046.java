package com.sdu.algorithm.offercode;

import java.util.LinkedList;
import java.util.Queue;

public class JZ046 {

  private static int LastRemaining_Solution(int n, int m) {
    if (n <= 0) {
      return -1;
    }
    if (n == 1) {
      return 0;
    }
    int remain = n;
    Queue<Integer> queue = new LinkedList<>();
    int cnt = 0;
    int number = 0;
    while (remain != 1) {
      if (number < n) {
        if (cnt == m - 1) {
          cnt = 0;
          number += 1;
          remain -= 1;
        } else {
          cnt += 1;
          queue.offer(number);
          number += 1;
        }
        continue;
      }

      while (cnt != m - 1) {
        queue.offer(queue.poll());
        cnt += 1;
      }
      queue.poll();
      cnt = 0;
      remain -= 1;
    }

    return queue.poll();
  }

  public static void main(String[] args) {
    System.out.println(LastRemaining_Solution(2, 2));
    System.out.println(LastRemaining_Solution(6, 3));
  }

}
