//Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
//
//Do not allocate extra space for another array, you must do this in place with constant memory.
//
//For example,
//Given input array nums = [1,1,2],
//
//Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. 
//It doesn't matter what you leave beyond the new length.

package com.computinglife.leetcode.easy;

public class RemoveDuplicatesfromSortedArray {
	public int removeDuplicates(int[] nums) {
		int length = nums.length;
		for (int i = 0; i < nums.length - 1; i++) {
			if (i == length - 1) {
				return length;
			}
			if (nums[i] == nums[i + 1]) {
				length--;
				// 移位
				for (int j = i; j < length; j++) {
					nums[j] = nums[j + 1];
				}
				i--;
			}
		}
		return length;
	}

	public static void main(String[] args) {
		RemoveDuplicatesfromSortedArray test = new RemoveDuplicatesfromSortedArray();
		int[] nums = { 1, 1, 2, 2, 2, 2, 2, 2 };
		System.out.println(test.removeDuplicates(nums));
	}

}
