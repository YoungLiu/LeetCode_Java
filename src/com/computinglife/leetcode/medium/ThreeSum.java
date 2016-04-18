//Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
//		Find all unique triplets in the array which gives the sum of zero.
//
//Note:
//Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
//The solution set must not contain duplicate triplets.
//    For example, given array S = {-1 0 1 2 -1 -4},
//
//    A solution set is:
//    (-1, 0, 1)
//    (-1, -1, 2)

package com.computinglife.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ret = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				twoSum(nums, -nums[i], i + 1, nums.length - 1, ret);
			}
		}
		return ret;
	}

	public void twoSum(int[] nums, int target, int front, int end, List<List<Integer>> ret) {
		while (front < end) {
			if (nums[front] + nums[end] == target) {
				List<Integer> tmp = new ArrayList<>();
				tmp.add(-target);
				tmp.add(nums[front]);
				tmp.add(nums[end]);
				ret.add(tmp);
				front++;
				while (front < end && nums[front] == nums[front - 1]) {
					front++;
				}
			} else if (nums[front] + nums[end] < target) {
				front++;
			} else {
				end--;
			}
		}
	}

}
