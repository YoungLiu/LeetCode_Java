/*Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

        For example, given the following matrix:

        1 0 1 0 0
        1 0 1 1 1
        1 1 1 1 1
        1 0 0 1 0
        Return 4.*/

package com.computinglife.leetcode.medium;

/**
 * Created by youngliu on 2/26/16.
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rowLen = matrix.length;
        int cloLen = matrix[0].length;

        int[][] dp = new int[rowLen][cloLen];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < rowLen; i++) {
            dp[i][0] = Character.getNumericValue(matrix[i][0]);
            if (dp[i][0] > max) {
                max = dp[i][0];
            }
        }

        for (int i = 0; i < cloLen; i++) {
            dp[0][i] = Character.getNumericValue(matrix[0][i]);
            if (dp[0][i] > max) {
                max = dp[0][i];
            }
        }

        for (int i = 1; i < rowLen; i++) {
            for (int j = 1; j < cloLen; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                    dp[i][j]++;
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return max * max;
    }
}
