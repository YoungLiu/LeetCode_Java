//Given a sorted integer array without duplicates, return the summary of its ranges.
//
//For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].

package com.computinglife.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
	public List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<>();
		if (nums.length == 1) {
			res.add(nums[0] + "");
			return res;
		}
		int start = 0;
		int end = 0;
		String tmp;
		for (int i = 0; i < nums.length; i++) {
			start = nums[i];
			if (i < nums.length - 2) {
				while (i < nums.length - 2 && (nums[i] + 1) == nums[i + 1]) {
					i++;
				}
			} else {
				// 这种情况一定是最后一个元素需要单独拿出来
				res.add(nums[i] + "");
			}

			end = nums[i];
			tmp = start + "->" + end;
			res.add(tmp);
			i++;
		}
		return res;
	}

}
