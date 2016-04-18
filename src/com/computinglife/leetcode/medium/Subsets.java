/*Given a set of distinct integers, nums, return all possible subsets.

        Note:
        Elements in a subset must be in non-descending order.
        The solution set must not contain duplicate subsets.
        For example,
        If nums = [1,2,3], a solution is:

        [
            [3],
            [1],
            [2],
            [1,2,3],
            [1,3],
            [2,3],
            [1,2],
            []
        ]*/

package com.computinglife.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by youngliu on 12/21/15.
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        //首先要对nums进行递增排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            subsetsHelper(nums, i, 0, new ArrayList<Integer>(), res);
        }
        return res;
    }

    public void subsetsHelper(int[] nums, int k, int start, ArrayList<Integer> item, List<List<Integer>> res) {
        if (item.size() == k) {
            res.add(new ArrayList<>(item));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            item.add(nums[i]);
            subsetsHelper(nums, k, i + 1, item, res);
            item.remove(item.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets test = new Subsets();
        int[] nums = {3,2,1};
        System.out.println(test.subsets(nums));
    }
}
