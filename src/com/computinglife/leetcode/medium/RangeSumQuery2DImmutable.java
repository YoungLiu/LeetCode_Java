/*Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined
        by its upper left corner (row1, col1) and lower right corner (row2, col2).
        The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

        Example:
        Given matrix = [
            [3, 0, 1, 4, 2],
            [5, 6, 3, 2, 1],
            [1, 2, 0, 1, 5],
            [4, 1, 0, 1, 7],
            [1, 0, 3, 0, 5]
        ]

        sumRegion(2, 1, 4, 3) -> 8
        sumRegion(1, 1, 2, 2) -> 11
        sumRegion(1, 2, 2, 4) -> 12
        Note:
        You may assume that the matrix does not change.
        There are many calls to sumRegion function.
        You may assume that row1 ≤ row2 and col1 ≤ col2.*/

package com.computinglife.leetcode.medium;

/**
 * Created by YanceyLiu on 5/12/2016.
 */
public class RangeSumQuery2DImmutable {

    private int[][] sum;

    public RangeSumQuery2DImmutable(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        sum = new int[matrix.length][matrix[0].length + 1];
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                sum[r][c + 1] = sum[r][c] + matrix[r][c];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        for (int r = row1; r <= row2; r++) {
            res += sum[r][col2 + 1] - sum[r][col1];
        }
        return res;
    }
}

class NumMatrix {

    private int[][] sum;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        sum = new int[matrix.length + 1][matrix[0].length + 1];
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                sum[r + 1][c + 1] = sum[r][c + 1] + sum[r + 1][c] + matrix[r][c] - sum[r][c];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2 + 1][col2 + 1] - sum[row1][col2 + 1] - sum[row2 + 1][col1] + sum[row1][col1];
    }
}
