//Determine if a Sudoku is valid
//The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
//Note:
//A valid Sudoku board (partially filled) is not necessarily solvable. 
//Only the filled cells need to be validated.

package com.computinglife.leetcode.easy;

public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {

		boolean[][] row = new boolean[9][9];
		boolean[][] column = new boolean[9][9];
		boolean[][] block = new boolean[9][9];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int tmp = board[i][j] - '1';
				if (board[i][j] == '.') {
					continue;
				}
				if (row[i][tmp] || column[tmp][j] || block[i - i % 3 + j / 3][tmp]) {
					return false;
				}
				row[i][tmp] = column[tmp][j] = block[i - i % 3 + j / 3][tmp] = true;
			}
		}
		return true;
	}

}
