//Given an array of size n, find the majority element. 
//The majority element is the element that appears more than ⌊ n/2 ⌋ times.
//
//You may assume that the array is non-empty and the majority element always exist in the array.

package com.computinglife.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
	public int majorityElement(int[] nums) {
		int length = nums.length;
		Map<Integer, Integer> aim = new HashMap<Integer, Integer>();
		for (Integer tmp : nums) {
			if (aim.containsKey(tmp)) {
				int tmp2 = aim.get(tmp).intValue();
				aim.put(tmp, ++tmp2);
			} else {
				aim.put(tmp, 1);
			}
		}
		int max = Integer.MIN_VALUE;
		int result = 0;
		for (Integer tmp : aim.keySet()) {
			if (aim.get(tmp).intValue() > Math.floor(length / 2) && aim.get(tmp).intValue() > max) {
				max = aim.get(tmp).intValue();
				result = tmp;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		MajorityElement test = new MajorityElement();
		int[] nums = { 1, 2, 2, 4 };
		System.out.println(test.majorityElement(nums));
	}
}
