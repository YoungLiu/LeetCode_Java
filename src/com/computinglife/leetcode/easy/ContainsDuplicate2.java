//Given an array of integers, find if the array contains any duplicates. 
//Your function should return true if any value appears at least twice in the array, 
//and it should return false if every element is distinct.

package com.computinglife.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate2 {
	public boolean containsDuplicate(int[] nums) {
		Map<Integer, Integer> tmp = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			if (tmp.containsKey(nums[i])) {
				return true;
			} else {
				tmp.put(nums[i], i);
			}
		}
		return false;
	}

}
