package com.sdu.algorithm.utils;

public class ArrayUtils {

    public static void printArray(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; ++i) {
            sb.append(array[i]).append(" ");
        }
        System.out.println(sb.toString());
    }

}
