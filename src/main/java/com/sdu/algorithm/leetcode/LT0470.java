package com.sdu.algorithm.leetcode;

import java.util.Random;

public class LT0470 {

    public static class SolBase {

        private Random random = new Random();

        public int rand7() {
            return random.nextInt(7) + 1;
        }

    }

    public static class Solution extends SolBase {

        public int rand10() {
            // 调用两次rand7()生成49个数, 考虑等概率, 则需要舍弃9个数, [0, 9]均匀出现4次即可
            // (a + b) % 10 + 1
            //   a  1  2  3  4  5  6  7
            // b
            // 1    3  4  5  5  6  7  8
            // 2    4  5  6  7  8  9  10
            // 3    5  6  7  8  9  10 1
            // 4    6  7  8  9  10 1  2
            // 5    7  8  9  10 1  2  3
            // 6    8  9  10 1  2  3  4
            // 7    9  10 1  2  3  4  5

            // 其中需删除:
            // 6  7  8
            // 8  9  10
            // 9  10 1
            int a = rand7(), b = rand7();
            while (true) {
                if (a >=5 && b <= 3) {
                    a = rand7();
                    b = rand7();
                } else {
                    break;
                }
            }
            return (a + b) % 10 + 1;
        }

    }

    public static void main(String[] args) {
        SolBase solBase = new SolBase();
        System.out.println(solBase.rand7());
    }

}
