/*Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

        For example, given the following triangle
        [
            [2],
           [3,4],
          [6,5,7],
         [4,1,8,3]
        ]
        The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

        Note:
        Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.*/

package com.computinglife.leetcode.medium;

import java.util.List;

/**
 * Created by youngliu on 1/5/16.
 */
public class Triangle {

    //此方法仅仅是自顶向下每次都寻求最小值，本次的最小值，不见得是全局的最小值
    public int minimumTotal_ERROR(List<List<Integer>> triangle) {
        int res = 0;
        if (triangle == null) {
            return res;
        }
        int index = 0;
        for (int i = 0; i < triangle.size(); i++) {
            res += triangle.get(i).get(index);
            if (i < triangle.size() - 1) {
                index = triangle.get(i + 1).get(index) > triangle.get(i + 1).get(index + 1) ? index + 1 : index;
            }
        }
        return res;
    }

    //自顶向下需要特殊处理首尾位
    public int minimumTotalBack(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int[] sum = new int[triangle.size()];
        sum[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            sum[i] = sum[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j > 0; j--) {
                sum[j] = (sum[j] < sum[j - 1] ? sum[j] : sum[j - 1]) + triangle.get(i).get(j);
            }
            sum[0] = sum[0] + triangle.get(i).get(0);
        }
        int min = sum[0];
        for (int i = 1; i < sum.length; i++) {
            if (sum[i] < min) {
                min = sum[i];
            }
        }
        return min;
    }

    //自底向上就解决的边界特殊处理问题
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int[] sum = new int[triangle.size()];
        for (int i = 0; i < triangle.size(); i++) {
            sum[i] = triangle.get(triangle.size() - 1).get(i);
        }
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                sum[j] = (sum[j] > sum[j + 1] ? sum[j + 1] : sum[j]) + triangle.get(i).get(j);
            }
        }
        return sum[0];
    }
}
