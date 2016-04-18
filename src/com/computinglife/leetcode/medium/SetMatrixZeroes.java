/*Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

        Follow up:
        Did you use extra space?
        A straight forward solution using O(mn) space is probably a bad idea.
        A simple improvement uses O(m + n) space, but still not the best solution.
        Could you devise a constant space solution?*/

package com.computinglife.leetcode.medium;

/**
 * Created by youngliu on 12/18/15.
 */
public class SetMatrixZeroes {
    //该方法空间复杂度为O(m+n)
    public void setZeroesBack(int[][] matrix) {
        int row = matrix.length;
        if (row < 1)
            return;
        int column = matrix[0].length;
        boolean[] rowRecorder = new boolean[row];
        boolean[] columnRedorder = new boolean[column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    rowRecorder[i] = true;
                    columnRedorder[j] = true;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (rowRecorder[i])
                    matrix[i][j] = 0;
                if (columnRedorder[j])
                    matrix[i][j] = 0;
            }
        }
    }

    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        if (row < 1) {
            return;
        }
        int column = matrix[0].length;
        boolean firstRowHasZero = false;
        boolean firstColumnHasZero = false;

        for (int i = 0; i < row && !firstColumnHasZero; i++) {
            if (matrix[i][0] == 0)
                firstColumnHasZero = true;
        }
        for (int i = 0; i < column && !firstRowHasZero; i++) {
            if (matrix[0][i] == 0)
                firstRowHasZero = true;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[0][j] == 0) matrix[i][j] = 0;
                if (matrix[i][0] == 0) matrix[i][j] = 0;
            }
        }

        if (firstRowHasZero) {
            for (int i = 0; i < column; i++) {
                matrix[0][i] = 0;
            }
        }

        if (firstColumnHasZero) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }

    }

}
