package com.sdu.algorithm.offercode;

public class JZ040 {

  private static int FindFirstBitIsOne(int number) {
    int flag = 1;
    int index = 0;
    while (flag != 0) {
      if ((number & flag) == flag) {
        return index;
      }
      index += 1;
      flag = flag << 1;
    }
    return index;
  }

  private static boolean isBitOne(int number, int index) {
    int mark = 1 << index;
    return (number & mark) == mark;
  }

  private static void FindNumberAppearOnce(int[] array, int[] num1, int[] num2) {
    int ret = 0;
    for (int num : array) {
      ret ^= num;
    }

    // 按照第一个比特位1, 数组拆分两部分
    int firstOneBitPos = FindFirstBitIsOne(ret);

    int number1 = 0, number2 = 0;
    for (int number : array) {
      if (isBitOne(number, firstOneBitPos)) {
        number1 ^= number;
      } else {
        number2 ^= number;
      }
    }
    num1[0] = number1;
    num2[0] = number2;
  }

  public static void main(String[] args) {
    int[] array = new int[] {2, 3, 5, 5, 6, 6, 7, 7};
    int[] num1 = new int[1];
    int[] num2 = new int[1];
    FindNumberAppearOnce(array, num1, num2);

    System.out.println(num1[0]);
    System.out.println(num2[0]);
  }

}
