/*Suppose a sorted array is rotated at some pivot unknown to you beforehand.

        (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

        Find the minimum element.

        You may assume no duplicate exists in the array.*/

package com.computinglife.leetcode.medium;

/**
 * Created by youngliu on 2/13/16.
 */
public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        if (end - start == 1) {
            return Math.min(nums[start], nums[end]);
        }

        int mid = (start + end) / 2;

        if (nums[start] < nums[end]) {
            return nums[start];
        }
        if (nums[mid] > nums[end]) {
            return helper(nums, mid, end);
        } else {
            return helper(nums, start, mid);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 1};
        FindMinimuminRotatedSortedArray test = new FindMinimuminRotatedSortedArray();
        System.out.println(test.findMin(nums));
    }
}
