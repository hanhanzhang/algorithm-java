package com.sdu.algorithm.offercode;

import java.util.ArrayList;

public class JZ042 {

    private static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        int low = 0, high = array.length - 1;
        ArrayList<Integer> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        while (low < high) {
            int ret = array[low] + array[high];
            if (ret == sum) {
                int temp = array[low] * array[high];
                if (temp < min) {
                    min = temp;
                    ans.clear();
                    ans.add(array[low]);
                    ans.add(array[high]);
                }
                low += 1;
                high -= 1;
            } else if (ret > sum) {
                high -= 1;
            } else {
                low += 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(FindNumbersWithSum(new int[] {1, 2, 4, 5}, 6));
        System.out.println(FindNumbersWithSum(new int[] {1, 2, 4, 7, 11, 16}, 10));
    }

}
