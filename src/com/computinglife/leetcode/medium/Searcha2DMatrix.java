/*Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

        Integers in each row are sorted from left to right.
        The first integer of each row is greater than the last integer of the previous row.
        For example,

        Consider the following matrix:

        [
            [1,   3,  5,  7],
            [10, 11, 16, 20],
            [23, 30, 34, 50]
        ]
        Given target = 3, return true.*/

package com.computinglife.leetcode.medium;

/**
 * Created by youngliu on 12/18/15.
 */
public class Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row < 1) {
            return false;
        }
        int column = matrix[0].length;
        int start = 0;
        int end = row - 1;
        int mid = 0;
        //确定行数,mid为最后确定的行号
        while (start <= end) {
            mid = (start + end) / 2;
            if (matrix[mid][0] < target)
                start = mid + 1;
            else if (matrix[mid][0] > target)
                end = mid - 1;
            else
                return true;
        }
        //确定行中有无目标数据
        if (matrix[mid][0] > target)
            mid--;
        //边界判断
        if (mid < 0)
            return false;
        start = 0;
        end = column - 1;
        int mid2 = 0;
        while (start <= end) {
            mid2 = (start + end) / 2;
            if (matrix[mid][mid2] < target)
                start = mid2 + 1;
            else if (matrix[mid][mid2] > target)
                end = mid2 - 1;
            else
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Searcha2DMatrix test = new Searcha2DMatrix();
//        int[][] nums = new int[][]{
//                {1, 3, 5, 7},
//                {10, 11, 16, 20},
//                {23, 30, 34, 50}
//        };
        int[][] nums = new int[][]{
                {1}
        };
        System.out.println(test.searchMatrix(nums, 0));
    }
}
