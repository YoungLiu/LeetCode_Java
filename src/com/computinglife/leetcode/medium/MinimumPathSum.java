/*Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right
        which minimizes the sum of all numbers along its path.

        Note: You can only move either down or right at any point in time.*/

package com.computinglife.leetcode.medium;

/**
 * Created by youngliu on 12/16/15.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int column;
        if (row == 0) {
            return 0;
        } else {
            column = grid[0].length;
        }
        int[] dp = new int[column + 1];
        int tmp = column;
        while (tmp >= 0) {
            dp[tmp--] = Integer.MAX_VALUE;
        }
        dp[1] = 0;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                dp[j] = grid[i - 1][j - 1] + Math.min(dp[j], dp[j - 1]);
            }
        }
        return dp[column];
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {2, 5, 9},
                {3, 4, 1},
                {7, 1, 6}
        };
        MinimumPathSum test = new MinimumPathSum();
        System.out.println(test.minPathSum(nums));
    }

}
