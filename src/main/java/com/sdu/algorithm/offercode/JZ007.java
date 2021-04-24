package com.sdu.algorithm.offercode;

public class JZ007 {

    private static int Fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int a = 1, b = 1;
        for (int i = 3; i <= n; ++i) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }


    public static void main(String[] args) {
        System.out.println(Fibonacci(3));
        System.out.println(Fibonacci(5));
        System.out.println(Fibonacci(6));
    }
}
