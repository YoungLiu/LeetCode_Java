/*Follow up for "Unique Paths":

        Now consider if some obstacles are added to the grids. How many unique paths would there be?

        An obstacle and empty space is marked as 1 and 0 respectively in the grid.

        For example,
        There is one obstacle in the middle of a 3x3 grid as illustrated below.

        [
          [0,0,0],
          [0,1,0],
          [0,0,0]
        ]
        The total number of unique paths is 2.

        Note: m and n will be at most 100.*/

package com.computinglife.leetcode.medium;

/**
 * Created by youngliu on 12/16/15.
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        if (row < 1) {
            return 0;
        }
        int column = obstacleGrid[0].length;
        int[] table = new int[column];
        if (obstacleGrid[0][0] == 1) {
            return 0;
        } else {
            table[0] = 1;
        }
        //初始化首行数据
        for (int i = 1; i < column && obstacleGrid[0][i] != 1; i++) {
            table[i] = 1;
        }
        for (int i = 1; i < row; i++) {
            if (obstacleGrid[i][0] == 1)
                table[0] = 0;
            for (int j = 1; j < column; j++) {
                if (obstacleGrid[i][j] != 1) {
                    table[j] += table[j - 1];
                } else {
                    table[j] = 0;
                }
            }
        }
        return table[column - 1];
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 0}
        };
        UniquePathsII test = new UniquePathsII();
        System.out.println(test.uniquePathsWithObstacles(nums));
    }
}
