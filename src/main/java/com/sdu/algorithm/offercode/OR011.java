package com.sdu.algorithm.offercode;

public class OR011 {

    private static int minArray(int[] numbers) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }

    public static void main(String[] args) {
        System.out.println(minArray(new int[] {3, 4, 5, 1, 2}));
    }

}
