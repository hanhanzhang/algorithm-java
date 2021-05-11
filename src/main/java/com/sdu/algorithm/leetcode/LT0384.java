package com.sdu.algorithm.leetcode;

import java.util.Random;

public class LT0384 {

    static class Solution {

        private int[] origin;
        private int[] array;

        private Random rand = new Random();

        public Solution(int[] nums) {
            this.array = nums;
            this.origin = nums.clone();

        }

        public int[] reset() {
            array = origin;
            origin = origin.clone();
            return array;
        }

        private int randRange(int min, int max) {
            return rand.nextInt(max - min) + min;
        }

        private void swapAt(int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        public int[] shuffle() {
            for (int i = 0; i < array.length; ++i) {
                swapAt(i, randRange(i, array.length));
            }
            return array;
        }
    }

    public static void main(String[] args) {

    }

}
