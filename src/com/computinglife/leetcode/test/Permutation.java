package com.computinglife.leetcode.test;

public class Permutation {

	private void allPermutation(int[] nums, int from, int to) {
		if (to <= 1) {
			return;
		}
		if (from == to) {
			for (int i = 0; i <= to; i++) {
				System.out.print(nums[i]);
			}
			System.out.println("\n");
		} else {
			for (int j = from; j <= to; j++) {
				swap(nums, j, from);
				allPermutation(nums, from + 1, to);
				swap(nums, j, from);
			}
		}
	}

	private void swap(int[] nums, int front, int back) {
		int tmp = nums[front];
		nums[front] = nums[back];
		nums[back] = tmp;
		return;
	}

	public static void main(String[] args) {
		Permutation test = new Permutation();
		int[] nums = { 1, 2, 3 };
		test.allPermutation(nums, 0, 2);
	}

}
