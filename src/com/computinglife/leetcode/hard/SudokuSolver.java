package com.computinglife.leetcode.hard;

/**
 * Created by yliu on 8/11/16.
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return;
        }
        solve(board);
        return;
    }

    public boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] >= '1' && board[i][j] <= '9'){
                    continue;
                }
                if(board[i][j] == '.'){
                    for(char tmp = '1'; tmp <= '9'; tmp++){
                        if(isValid(board, i, j, tmp)){
                            board[i][j] = tmp;
                            if(solve(board)){
                                return true;
                            }else{
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int i, int j, char tmp){
        for(int column = 0; column < board[0].length; column++){
            if(board[i][column] == tmp){
                return false;
            }
        }
        for(int row = 0; row < board.length; row++){
            if(board[row][j] == tmp){
                return false;
            }
        }
        for(int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++){
            for(int column = (j / 3) * 3; column < (j / 3) * 3 + 3; column++){
                if(board[row][column] == tmp){
                    return false;
                }
            }
        }
        return true;
    }
}
