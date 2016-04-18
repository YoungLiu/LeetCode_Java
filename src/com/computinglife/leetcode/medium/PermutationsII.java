//Given a collection of numbers that might contain duplicates, return all possible unique permutations.
//
//For example,
//[1,1,2] have the following unique permutations:
//[1,1,2], [1,2,1], and [2,1,1].

package com.computinglife.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		permutating(res, 0, nums);
		return res;
	}

	public void permutating(List<List<Integer>> res, int start, int[] nums) {
		if (start == nums.length) {
			List<Integer> tmp = new ArrayList<>();
			for (int num : nums) {
				tmp.add(num);
			}
			res.add(tmp);
			return;
		}

		for (int i = start; i < nums.length; i++) {
			if (i != start && nums[start] == nums[i]) {
				continue;
			}
			swap(nums, start, i);
			permutating(res, start + 1, Arrays.copyOf(nums, nums.length));
		}
	}

	public void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public static void main(String[] args) {
		PermutationsII test = new PermutationsII();
		int[] nums = { 1, 1, 2 };
		System.out.println(test.permuteUnique(nums));
	}
}
