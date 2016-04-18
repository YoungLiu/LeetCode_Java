//Given an array of integers and an integer k, 
//find out whether there are two distinct indices i and j in the array 
//such that nums[i] = nums[j] and the difference between i and j is at most k.

package com.computinglife.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
	// 效率低的方法
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if (nums.length == 0 || nums.length == 1) {
			return false;
		}
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j <= i + k && j < nums.length; j++) {
				if (nums[i] == nums[j]) {
					return true;
				}
			}
		}
		return false;
	}

	// 高效方法
	public boolean containsNearbyDuplicate2(int[] nums, int k) {
		Map<Integer, Integer> tmp = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			if (!tmp.containsKey(nums[i])) {
				tmp.put(nums[i], i);
			} else {
				if (Math.abs(tmp.get(nums[i]) - i) <= k) {
					return true;
				} else {
					tmp.put(nums[i], i);
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		ContainsDuplicate test = new ContainsDuplicate();
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
		System.err.println(test.containsNearbyDuplicate(nums, 29999));
	}
}
