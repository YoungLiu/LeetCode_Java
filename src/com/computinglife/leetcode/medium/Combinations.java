/*Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

        For example,
        If n = 4 and k = 2, a solution is:

        [
        [2,4],
        [3,4],
        [2,3],
        [1,2],
        [1,3],
        [1,4],
        ]*/

package com.computinglife.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youngliu on 12/19/15.
 */
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < 1 || n < k)
            return res;
        combineHelper(n, k, 1, new ArrayList<Integer>(), res);
        return res;
    }

    public void combineHelper(int n, int k, int start, ArrayList<Integer> item, List<List<Integer>> res) {
        if (item.size() == k) {
            //此处要注意，item后面还会用到，所以要重新将其内容放到一个新list之中
            res.add(new ArrayList<>(item));
            return;
        }
        for (int i = start; i <= n; i++) {
            item.add(i);
            combineHelper(n, k, i + 1, item, res);
            item.remove(item.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combinations test = new Combinations();
        System.out.println(test.combine(3, 2));
    }

}
