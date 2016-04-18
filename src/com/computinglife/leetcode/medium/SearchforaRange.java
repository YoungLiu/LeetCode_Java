//Given a sorted array of integers, find the starting and ending position of a given target value.
//
//Your algorithm's runtime complexity must be in the order of O(log n).
//
//If the target is not found in the array, return [-1, -1].
//
//For example,
//Given [5, 7, 7, 8, 8, 10] and target value 8,
//return [3, 4].

package com.computinglife.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchforaRange {
	public int[] searchRange(int[] nums, int target) {
		if (nums[nums.length - 1] < target || nums[0] > target || nums == null) {
			return new int[] { -1, -1 };
		}

		List<Integer> ret = new ArrayList<Integer>();
		int start = 0;
		int end = nums.length - 1;
		int mid = (start + end) / 2;
		while (start <= end) {
			if (nums[mid] < target) {
				start = mid + 1;
				mid = (start + end) / 2;
			} else if (nums[mid] > target) {
				end = mid - 1;
				mid = (start + end) / 2;
			} else {
				// 相等
				// 前向
				int tmp = mid;
				while (mid < nums.length && nums[mid] == target) {
					ret.add(mid);
					mid++;
				}
				mid = tmp-1;
				// 后向
				while (mid >= 0 && nums[mid] == target) {
					ret.add(mid);
					mid--;
				}
				break;
			}
		}
		Collections.sort(ret);
		if (ret.size() == 1) {
			return new int[] { ret.get(0), ret.get(0) };
		}
		if (ret.size() == 0) {
			return new int[] { -1, -1 };
		}
		int[] res = new int[2];
		res[0] = ret.get(0);
		res[1] = ret.get(ret.size() - 1);
		return res;
	}

	public static void main(String[] args) {
		SearchforaRange test = new SearchforaRange();
		int[] nums = { 2, 2 };
		int[] res = test.searchRange(nums, 2);
		for (int tmp : res) {
			System.out.println(tmp);
		}
	}
}
