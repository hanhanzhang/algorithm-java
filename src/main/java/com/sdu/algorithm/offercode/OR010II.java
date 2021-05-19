package com.sdu.algorithm.offercode;

public class OR010II {

    private static int numWays(int n) {
        int a = 1, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(numWays(3));
        System.out.println(numWays(7));
    }

}
