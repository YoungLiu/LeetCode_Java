//Given a sorted array and a target value, return the index if the target is found. 
//		If not, return the index where it would be if it were inserted in order.
//
//You may assume no duplicates in the array.
//
//Here are few examples.
//[1,3,5,6], 5 → 2
//[1,3,5,6], 2 → 1
//[1,3,5,6], 7 → 4
//[1,3,5,6], 0 → 0

package com.computinglife.leetcode.medium;

public class SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
		if (nums == null) {
			return 0;
		}
		int start = 0;
		int end = nums.length - 1;
		int mid = (start + end) / 2;
		while (start <= end) {
			if (nums[mid] > target) {
				end = mid - 1;
				mid = (start + end) / 2;
			} else if (nums[mid] < target) {
				start = mid + 1;
				mid = (start + end) / 2;
			} else {
				// 相等
				return mid;
			}
		}
		// 未找到
		if (nums[mid] < target)
			return ++mid;
		else
			return --mid < 0 ? 0 : mid;
	}
}
