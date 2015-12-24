/*Given a collection of integers that might contain duplicates, nums, return all possible subsets.

        Note:
        Elements in a subset must be in non-descending order.
        The solution set must not contain duplicate subsets.
        For example,
        If nums = [1,2,2], a solution is:

        [
            [2],
            [1],
            [1,2,2],
            [2,2],
            [1,2],
            []
        ]*/

package com.computinglife.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by youngliu on 12/24/15.
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            subsetsWithDupHelper(nums, i, 0, new ArrayList<Integer>(), res);
        }
        return res;
    }

    public void subsetsWithDupHelper(int[] nums, int k, int start, ArrayList<Integer> item, List<List<Integer>> res) {
        if (item.size() == k) {
            if (!res.contains(item)) {
                res.add(new ArrayList<>(item));
            }
            return;
        }
        for (int i = start; i < nums.length; i++) {
            item.add(nums[i]);
            subsetsWithDupHelper(nums, k, i + 1, item, res);
            item.remove(item.size() - 1);
        }
    }

    public static void main(String[] args) {
        SubsetsII test = new SubsetsII();
        int[] nums = new int[]{1, 2, 2};
        System.out.println(test.subsetsWithDup(nums));
    }
}
