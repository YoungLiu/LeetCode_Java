//Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//
//If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
//
//The replacement must be in-place, do not allocate extra memory.
//
//Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
//1,2,3 → 1,3,2
//3,2,1 → 1,2,3
//1,1,5 → 1,5,1

package com.computinglife.leetcode.medium;

import java.util.Arrays;

public class NextPermutation {

	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length == 1) {
			return;
		}
		int firstIndex = -1;
		for (int i = nums.length - 2; i > firstIndex; i--) {
			if (nums[i] < nums[i + 1]) {
				firstIndex = i;
				break;
			}
		}
		if (firstIndex == -1) {
			Arrays.sort(nums);
			return;
		}
		int secondIndex = -1;
		for (int i = nums.length - 1; i > firstIndex; i--) {
			if (nums[i] > nums[firstIndex]) {
				secondIndex = i;
				break;
			}
		}
		int tmp = nums[firstIndex];
		nums[firstIndex] = nums[secondIndex];
		nums[secondIndex] = tmp;
		Arrays.sort(nums, firstIndex + 1, nums.length);
		return;
	}

}
