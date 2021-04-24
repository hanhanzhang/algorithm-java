package com.sdu.algorithm.offercode;

public class JZ006 {

  private static int minNumberInRotateArray(int [] array) {
    int low = 0, high = array.length - 1;
    while (low < high) {
      int mid = low + (high - low) / 2;
      if (array[mid] < array[high]) {
        high = mid;
      } else if (array[mid] > array[high]) {
        low = mid + 1;
      } else {
        // 示例: 1, 0, 1, 1, 1
        // 示例: 1, 1, 1, 0, 1
        // 这种情形下, 慢慢缩小空间
        high -= 1;
      }
    }
    return array[low];
  }

  public static void main(String[] args) {
    System.out.println(minNumberInRotateArray(new int[] {6, 1, 2, 3, 4, 5}));
    System.out.println(minNumberInRotateArray(new int[] {5, 6, 1, 2, 3, 4}));
    System.out.println(minNumberInRotateArray(new int[] {4, 5, 6, 1, 2}));
    System.out.println(minNumberInRotateArray(new int[] {1, 0, 1, 1, 1}));
  }

}
