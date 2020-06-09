package com.sdu.algorithm.leetcode;

public class LT576 {

  private static int findPaths1(int m, int n, int N, int i, int j) {
    /*
     * 动态规划
     * dp[i][j][k]: 表示从边界到(i, j)处走K步的所有路径数
     *
     * dp[i][j][k] = dp[i - 1][j][k - 1] + dp[i + 1][j][k - 1] +
     *               dp[i][j - 1][k - 1] + dp[i][j + 1][k - 1]
     * */
    int[][] moved = new int[][] {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    int[][][]dp = new int[m][n][N + 1];
    int mod = 1000000007;
    for (int k = 1; k <= N; ++k) {
      for (int x = 0; x < m; ++ x) {
        for (int y = 0; y < n; ++y) {
          for (int d = 0; d < 4; ++d) {
            int newX = x + moved[d][0];
            int newY = y + moved[d][1];
            if (newX < 0 || newX + 1 > m || newY < 0 || newY + 1 > n) {
              // 边界情况
              dp[x][y][k] += 1;
            } else {
              dp[x][y][k] = (dp[x][y][k] + dp[newX][newY][k - 1]) % mod;
            }
          }
        }
      }
    }

    return dp[i][j][N];
  }

  private static int findPaths(int m, int n, int N, int i, int j) {
    /*
     * 深度搜索[运行超时]
     *
     * 本题是找的路径, 从下个点返回到当前点已表示不同路径, 故不需要visited
     * */
    if (N == 0) {
      return i < 0 || i >= m || j < 0  || j >= n ? 1 : 0;
    }
    if (i < 0 || i > m - 1 || j < 0  || j > n - 1) {
      return 1;
    }

    int[][] moved = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    int ans = 0;
    for (int k = 0; k < 4; ++k) {
      int[] p = moved[k];
      int newX = i + p[0];
      int nexY = j + p[1];
      ans += findPaths(m, n, N - 1, newX, nexY);
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(findPaths(2, 2, 2, 0, 0));
    System.out.println(findPaths(1, 3, 3, 0, 1));

    System.out.println(findPaths1(2, 2, 2, 0, 0));
    System.out.println(findPaths1(1, 3, 3, 0, 1));
  }

}
