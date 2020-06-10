package com.sdu.algorithm.offercode;

public class JZ050 {

  private static boolean duplicate(int numbers[],int length, int[] duplication) {
    boolean valid = false;
    for (int i = 0; i < length; ++i) {
      int pos = Math.abs(numbers[i]);
      if (numbers[pos] < 0 && !valid) {
        // 重复且第一次出现
        valid = true;
        duplication[0] = Math.abs(numbers[i]);
      } else {
        numbers[pos] *= -1;
      }
    }

    if (!valid) {
      duplication[0] = -1;
    }
    return valid;
  }

  public static void main(String[] args) {
    int[] ans = new int[1];
    System.out.println(duplicate(new int[] {2, 1, 3, 1, 4}, 5, ans));
    System.out.println(ans[0]);
  }

}
