package com.sdu.algorithm.offercode;

public class JZ012 {

    private static double square(double base, int n) {
        if (n == 0) {
            return 1.0d;
        }
        if (n == 1) {
            return base;
        }
        double ret = square(base, n / 2);
        return ret * ret;
    }

    private static double power(double base, int n) {
        // TODO: 非递归方式
        if (n < 0) {
            n = -n;
            base = 1 / base;
        }
        // 折半
        // 若n=2m, 则 x^n = (x^m)^2
        // 若n=2m+1, 则x^n = (x^m)^2 * x;
        if (n % 2 == 0) {
            return square(base, n);
        }
        return square(base, n - 1) * base;
    }

    public static void main(String[] args) {
        System.out.println(power(2, -1));
        System.out.println(power(2, -2));
        System.out.println(power(3, 1));
        System.out.println(power(2, 4));
        System.out.println(power(2, 5));
    }

}
