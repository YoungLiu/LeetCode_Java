//Given an array S of n integers, find three integers in S 
//such that the sum is closest to a given number, target. 
//Return the sum of the three integers. 
//You may assume that each input would have exactly one solution.
//
//    For example, given array S = {-1 2 1 -4}, and target = 1.
//
//    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

package com.computinglife.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		Map<String, Integer> ret = new HashMap<>();
		ret.put("min", Integer.MAX_VALUE);
		ret.put("sum", 0);
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				targetCloset(nums, target, i + 1, nums.length - 1, ret);
			}
		}
		return ret.get("sum");
	}

	public void targetCloset(int[] nums, int target, int front, int end, Map<String, Integer> ret) {
		while (front < end) {
			if (Math.abs(nums[front - 1] + nums[front] + nums[end] - target) <= ret.get("min")) {
				ret.put("min", Math.abs(nums[front - 1] + nums[front] + nums[end] - target));
				ret.put("sum", nums[front - 1] + nums[front] + nums[end]);
				if (nums[front - 1] + nums[front] + nums[end] > target) {
					end--;
				} else {
					front++;
				}
			} else {
				if (nums[front - 1] + nums[front] + nums[end] > target) {
					end--;
				} else {
					front++;
				}
			}
		}
	}

	public static void main(String[] args) {
		ThreeSumClosest test = new ThreeSumClosest();
		int[] nums = { 0, 2, 1, -3 };
		System.out.println(test.threeSumClosest(nums, 1));
	}
}
