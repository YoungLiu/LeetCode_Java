/*According to the Wikipedia's article: "The Game of Life, also known simply as Life,
        is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

        Given a board with m by n cells, each cell has an initial state live (1) or dead (0).
        Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules
        (taken from the above Wikipedia article):

        Any live cell with fewer than two live neighbors dies, as if caused by under-population.
        Any live cell with two or three live neighbors lives on to the next generation.
        Any live cell with more than three live neighbors dies, as if by over-population..
        Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
        Write a function to compute the next state (after one update) of the board given its current state.

        Follow up:
        Could you solve it in-place? Remember that the board needs to be updated at the same time:
        You cannot update some cells first and then use their updated values to update other cells.
        In this question, we represent the board using a 2D array. In principle, the board is infinite,
        which would cause problems when the active area encroaches the border of the array.
        How would you address these problems?*/

package com.computinglife.leetcode.medium;

/**
 * Created by YanceyLiu on 5/28/2016.
 */
public class GameofLife {
    //the 1st bits represent next generation
    //the 2st bits represent current generation
    //0:die 1:live
    public void gameOfLife(int[][] board) {
        int row = board.length;
        int column = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int neighbors = neighborsInLives(board, i, j);
                if ((board[i][j] & 1) == 1 && (neighbors < 2 || neighbors > 3)) {
                    board[i][j] = 1;
                } else if ((board[i][j] & 1) == 1 && (neighbors == 3 || neighbors == 2)) {
                    board[i][j] = 3;
                } else if ((board[i][j] & 1) == 0 && neighbors == 3) {
                    board[i][j] = 2;
                }
            }
        }
        //next generation
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                board[i][j] >>>= 1;
            }
        }
    }

    private int neighborsInLives(int[][] board, int cow, int column) {
        int neighbors = 0;
        for (int i = cow - 1; i <= cow + 1; i++) {
            for (int j = column - 1; j <= column + 1; j++) {
                if (i >= 0 && i < board.length && j >= 0 && j < board[0].length)
                    neighbors += board[i][j] & 1;
            }
        }
        neighbors -= board[cow][column] & 1;
        return neighbors;
    }
}
