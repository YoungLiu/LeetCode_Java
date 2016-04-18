/*Find all possible combinations of k numbers that add up to a number n,
        given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

        Ensure that numbers within the set are sorted in ascending order.


        Example 1:

        Input: k = 3, n = 7

        Output:

        [[1,2,4]]

        Example 2:

        Input: k = 3, n = 9

        Output:

        [[1,2,6], [1,3,5], [2,3,4]]*/

package com.computinglife.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youngliu on 2/25/16.
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(result, list, 1, n, k);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int start, int sum, int k) {
        if (sum == 0 && list.size() == k) {
            List<Integer> item = new ArrayList<>(list);
            result.add(item);
        }
        for (int i = start; i <= 9; i++) {
            if (sum - i < 0)
                break;
            if (list.size() > k)
                break;
            list.add(i);
            dfs(result, list, i + 1, sum - i, k);
            list.remove(list.size() - 1);
        }
    }
}
