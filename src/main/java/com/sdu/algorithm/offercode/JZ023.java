package com.sdu.algorithm.offercode;

public class JZ023 {

  private static boolean verifySequenceOfBST(int[] sequence, int start, int end) {
    if (start < 0) {
      return false;
    }
    if (start >= end) {
      return true;
    }
    int root = sequence[end];
    int pos = -1;
    // 找到第一个比root大的节点, 划为左子树区间, 其他为右子树区间
    for (int i = start; i < end; ++i) {
      if (sequence[i] > root) {
        pos = i;
        break;
      }
    }

    if (pos == -1) {
      // 左子树[start, end - 1]
      return verifySequenceOfBST(sequence, start, end - 1);
    }

    // 左子树[start, pos - 1], 判断右子树是都大于root
    for (int i = pos; i < end; ++i) {
      if (sequence[i] <= root) {
        return false;
      }
    }

    return verifySequenceOfBST(sequence, start, pos - 1)
        && verifySequenceOfBST(sequence, pos, end - 1);
  }

  private static boolean VerifySequenceOfBST(int[] sequence) {
    return verifySequenceOfBST(sequence, 0, sequence.length - 1);
  }

  public static void main(String[] args) {
    System.out.println(VerifySequenceOfBST(new int[] {3, 5, 4, 8, 11, 10, 6}));
    System.out.println(VerifySequenceOfBST(new int[] {5, 7, 6, 9, 11, 10, 8}));
    System.out.println(VerifySequenceOfBST(new int[] {7, 4, 6, 5}));

    System.out.println(VerifySequenceOfBST(new int[] {4, 6, 7, 5}));
  }

}
