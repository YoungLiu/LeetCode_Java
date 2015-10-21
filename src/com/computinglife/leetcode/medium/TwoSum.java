//Given an array of integers, find two numbers such that they add up to a specific target number.
//
//The function twoSum should return indices of the two numbers such that they add up to the target, 
//where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
//
//You may assume that each input would have exactly one solution.
//
//Input: numbers={2, 7, 11, 15}, target=9
//Output: index1=1, index2=2
//关键在于一次遍历完成查找

package com.computinglife.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		int[] ret = new int[2];
		ret[0] = -1;
		ret[1] = -1;
		int index = 0;
		Map<Integer, Integer> dumpMap = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			if (dumpMap.containsKey(target - nums[i])) {
				index = dumpMap.get(target - nums[i]) + 1;
				ret[0] = Math.min(i + 1, index);
				ret[1] = Math.max(i + 1, index);
			}
			dumpMap.put(nums[i], i);
		}
		return ret;
	}
}
