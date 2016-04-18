/*Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

        A region is captured by flipping all 'O's into 'X's in that surrounded region.

        For example,
        X X X X
        X O O X
        X X O X
        X O X X
        After running your function, the board should be:

        X X X X
        X X X X
        X X X X
        X O X X*/

package com.computinglife.leetcode.medium;

/**
 * Created by youngliu on 1/8/16.
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        int row = board.length;
        if (row <= 2) {
            return;
        }
        int col = board[0].length;
        if (col <= 2) {
            return;
        }
        //顶部
        for (int j = 0; j < col; j++) {
            if (board[0][j] == 'O') {
                board[0][j] = '#';
                bfs(board, 0, j, row, col);
            }
        }
        //底部
        for (int j = 0; j < col; j++) {
            if (board[row - 1][j] == 'O') {
                board[row - 1][j] = '#';
                bfs(board, row - 1, j, row, col);
            }
        }
        //左部
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = '#';
                bfs(board, i, 0, row, col);
            }
        }
        //右部
        for (int i = 0; i < row; i++) {
            if (board[i][col - 1] == 'O') {
                board[i][col - 1] = '#';
                bfs(board, i, col - 1, row, col);
            }
        }

        //重新处理矩阵内部标记
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

    }

    //向上下左右四个方向做广度优先遍历
    private void bfs(char[][] board, int i, int j, int row, int col) {
        //上
        if (i > 1 && board[i - 1][j] == 'O') {
            board[i - 1][j] = '#';
            bfs(board, i - 1, j, row, col);
        }
        //下
        if (i < row - 1 && board[i + 1][j] == 'O') {
            board[i + 1][j] = '#';
            bfs(board, i + 1, j, row, col);
        }
        //左
        if (j > 1 && board[i][j - 1] == 'O') {
            board[i][j - 1] = '#';
            bfs(board, i, j - 1, row, col);
        }
        //右
        if (j < col - 1 && board[i][j + 1] == 'O') {
            board[i][j + 1] = '#';
            bfs(board, i, j + 1, row, col);
        }
    }
}
