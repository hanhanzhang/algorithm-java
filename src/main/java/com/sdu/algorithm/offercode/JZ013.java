package com.sdu.algorithm.offercode;

public class JZ013 {

  private static void reOrderArray(int [] array) {
    if (array == null || array.length == 0) {
      return;
    }
    //
    int cur = 0;
    while (cur < array.length) {
      if (array[cur] % 2 == 0) {
        // 若是偶数, 向后找到第一个奇数
        int tmp = cur + 1;
        while (tmp < array.length && array[tmp] % 2 == 0) {
          tmp += 1;
        }
        if (tmp == array.length) {
          // 后面已全部是偶数, 则调整结束
          return;
        }
        int evenNum = array[tmp];
        // 移动偶数, 保持相对位置不变
        for (int i = tmp; i > cur; --i) {
          array[i] = array[i - 1];
        }
        array[cur] = evenNum;
      }
      cur += 1;
    }
  }

  public static void main(String[] args) {
    int[] array = new int[] {1, 2, 4, 3, 5, 6, 7};
    reOrderArray(array);
    for (int a : array) {
      System.out.println(a);
    }
  }

}
