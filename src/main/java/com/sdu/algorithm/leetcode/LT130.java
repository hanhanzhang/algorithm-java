package com.sdu.algorithm.leetcode;

public class LT130 {

  private static void dfs(char[][] board, int i , int j) {
    if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || board[i][j] == 'X' || board[i][j] == '#') {
      return;
    }
    // 用'#'表示已连通
    board[i][j] = '#';
    dfs(board, i - 1, j);
    dfs(board, i + 1, j);
    dfs(board, i, j - 1);
    dfs(board, i, j + 1);
  }

  private static void solve(char[][] board) {
    // 问题转变: 只要与边界'O'连通的'O'是都不可变为'X', 故从边界'O'出发
    for (int i = 0; i < board.length; ++i) {
      for (int j = 0; j < board[i].length; ++j) {
        // 寻找与边界连通的'O'
        if (i == 0 || j == 0 || i + 1 == board.length || j + 1 == board[i].length) {
          if (board[i][j] == 'O') {
            dfs(board, i, j);
          }
        }
      }
    }

    for (int i = 0; i < board.length; ++i) {
      for (int j = 0; j < board[i].length; ++j) {
        if (board[i][j] == '#') {
          board[i][j] = 'O';
        } else if (board[i][j] == 'O') {
          board[i][j] = 'X';
        }
      }
    }

  }

  public static void main(String[] args) {
    char[][] board5 = new char[][]{
        {'X','O','X','O','X','O','O','O','X','O'},
        {'X','O','O','X','X','X','O','O','O','X'},
        {'O','O','O','O','O','O','O','O','X','X'},
        {'O','O','O','O','O','O','X','O','O','X'},
        {'O','O','X','X','O','X','X','O','O','O'},
        {'X','O','O','X','X','X','O','X','X','O'},
        {'X','O','X','O','O','X','X','O','X','O'},
        {'X','X','O','X','X','O','X','O','O','X'},
        {'O','O','O','O','X','O','X','O','X','O'},
        {'X','X','O','X','X','X','X','O','O','O'}
    };

    solve(board5);
    for (int i = 0; i < board5.length; ++i) {
      System.out.println(board5[i]);
    }



  }

}
