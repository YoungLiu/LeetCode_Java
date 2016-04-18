//Given an array S of n integers, are there elements a, b, c, 
//and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
//
//Note:
//Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
//The solution set must not contain duplicate quadruplets.
//    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
//
//    A solution set is:
//    (-1,  0, 0, 1)
//    (-2, -1, 1, 2)
//    (-2,  0, 0, 2)

package com.computinglife.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		int sum;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int start = j + 1;
				int end = nums.length - 1;
				while (start < end) {
					sum = nums[i] + nums[j] + nums[start] + nums[end];
					if (sum == target) {
						List<Integer> tmp = new ArrayList<Integer>();
						tmp.add(nums[i]);
						tmp.add(nums[j]);
						tmp.add(nums[start]);
						tmp.add(nums[end]);
						ret.add(tmp);
						start++;
						end--;
						while (start < end && nums[start] == nums[start - 1])
							start++;
						while (start < end && nums[end] == nums[end + 1])
							end--;
					} else if (sum < target) {
						start++;
						while (start < end && nums[start] == nums[start - 1])
							start++;
					} else {
						end--;
						while (start < end && nums[end] == nums[end + 1])
							end--;
					}
				}
				while (j < nums.length - 1 && nums[j + 1] == nums[j]) {
					j++;
				}
			}
			while (i < nums.length - 1 && nums[i + 1] == nums[i]) {
				i++;
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		FourSum test = new FourSum();
		int[] nums = { 1, 0, -1, 0, -2, 2 };
		System.out.println(test.fourSum(nums, 0));
	}
}
