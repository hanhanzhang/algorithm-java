package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.ArrayUtils;

public class LT0498 {

    private static boolean valid(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    private static int[] findDiagonalOrder(int[][] mat) {
        int[][] moved = new int[][] {{-1, 1}, {1, -1}};
        int i = 0, j = 0, index = 0, pos = 0, n = mat.length, m = mat[0].length;
        int[] res = new int[n * m];
        while (pos != res.length) {
            if (i < 0 || i >= n || j < 0 || j >= m) {
                // 还原
                int[] move = moved[index];
                i = i - move[0];
                j = j - move[1];
                if (index == 1) {
                    i = i + move[0];
                    if (!valid(i, j, n, m)) {
                        i = i - move[0];
                        j = j + 1;
                    }
                } else {
                    j = j + move[1];
                    if (!valid(i, j, n, m)) {
                        j = j - move[1];
                        i = i + 1;
                    }
                }
                index = (index + 1) % 2;
                continue;
            }
            res[pos++] = mat[i][j];
            int[] move = moved[index];
            i = i + move[0];
            j = j + move[1];
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        ArrayUtils.printArray(findDiagonalOrder(mat));
    }

}
