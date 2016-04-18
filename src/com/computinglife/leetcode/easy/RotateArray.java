//Rotate an array of n elements to the right by k steps.
//
//For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
//
//Note:
//Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

package com.computinglife.leetcode.easy;

public class RotateArray {
	public void rotate2(int[] nums, int k) {
		int tmp = 0;
		int length = nums.length;
		k %= length;
		for (int i = 0; i < k; i++) {
			tmp = nums[length - 1];
			for (int j = length - 1; j > 0; j--) {
				nums[j] = nums[j - 1];
			}
			nums[0] = tmp;
		}
	}

	public void rotate(int[] nums, int k) {
		int length = nums.length;
		k %= length;
		reverse(nums, 0, length - k - 1);
		reverse(nums, length - k, length - 1);
		reverse(nums, 0, length - 1);
	}

	public void reverse(int[] nums, int start, int end) {
		int tmp = 0;
		for (; start < end; start++, end--) {
			tmp = nums[end];
			nums[end] = nums[start];
			nums[start] = tmp;
		}
	}

	public static void main(String[] args) {
		RotateArray test = new RotateArray();
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		test.rotate(nums, 3);
		System.out.println(nums);
	}
}
