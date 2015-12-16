/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

        The robot can only move either down or right at any point in time.
        The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

        How many possible unique paths are there?
*/

package com.computinglife.leetcode.medium;

/**
 * Created by youngliu on 12/16/15.
 */
public class UniquePaths {

    //普通回溯法效率较低，会严重超时
    public int uniquePathsTraceBack(int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        return uniquePathsTraceBack(m - 1, n) + uniquePathsTraceBack(n, n - 1);
    }

    //动态规划一(横纵两个方向都为1，因为只能向右或者向下),但是实际运行时间仍然不满意
    public int uniquePaths(int m, int n) {
        int tmpM = m;
        int tmpN = n;
        int[][] table = new int[m][n];
        while (n > 0) {
            table[0][--n] = 1;
        }
        while (m > 0) {
            table[--m][0] = 1;
        }
        for (int i = 1; i < tmpM; i++) {
            for (int j = 1; j < tmpN; j++) {
                table[i][j] = table[i - 1][j] + table[i][j - 1];
            }
        }
        return table[tmpM - 1][tmpN - 1];
    }


    public static void main(String[] args) {
        UniquePaths test = new UniquePaths();
        Long start = System.currentTimeMillis();
        System.out.println(test.uniquePaths(12, 12));
        Long end = System.currentTimeMillis();
        System.out.println(end - start);

    }
}
