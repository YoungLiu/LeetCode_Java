//Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
//Each element in the array represents your maximum jump length at that position.
//
//Determine if you are able to reach the last index.
//
//For example:
//A = [2,3,1,1,4], return true.
//
//A = [3,2,1,0,4], return false.

package com.computinglife.leetcode.medium;

public class JumpGame {
	public boolean canJump(int[] nums) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		int current = 0;
		for (int i = 0; i <= current && i < nums.length; i++) {
			current = Math.max(nums[i] + i, current);
		}
		if (current < nums.length - 1) {
			return false;
		}
		return true;
	}
}
