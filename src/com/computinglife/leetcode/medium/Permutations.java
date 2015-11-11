//Given a collection of numbers, return all possible permutations.
//
//For example,
//[1,2,3] have the following permutations:
//[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

package com.computinglife.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		forHelp(new ArrayList<Integer>(), res, nums);
		return res;
	}

	public void forHelp(List<Integer> current, List<List<Integer>> res, int[] nums) {
		if (current.size() == nums.length) {
			res.add(new ArrayList<>(current));
		}
		for (int i = 0; i < nums.length; i++) {
			if (!current.contains(nums[i])) {
				current.add(nums[i]);
				forHelp(current, res, nums);
				current.remove(current.size() - 1);
			}
		}
	}
}
