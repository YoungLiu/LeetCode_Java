//Find the contiguous subarray within an array (containing at least one number) 
//which has the largest sum.
//
//For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
//the contiguous subarray [4,−1,2,1] has the largest sum = 6.

package com.computinglife.leetcode.medium;

public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int local = nums[0];
		int global = nums[0];
		for (int i = 1; i < nums.length; i++) {
			local = Math.max(nums[i], local + nums[i]);
			global = Math.max(local, global);
		}
		return global;
	}
}
