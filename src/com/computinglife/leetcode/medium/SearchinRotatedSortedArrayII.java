/*Follow up for "Search in Rotated Sorted Array":
        What if duplicates are allowed?

        Would this affect the run-time complexity? How and why?

        Write a function to determine if a given target is in the array.*/

package com.computinglife.leetcode.medium;

/**
 * Created by youngliu on 12/22/15.
 */
public class SearchinRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int l = 0;
        int r = nums.length - 1;
        int m;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] == target) {
                return true;
            }
            if (nums[m] < nums[r]) {
                //右部有序
                if (target > nums[m] && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else if (nums[m] > nums[r]) {
                //左部有序
                if (target >= nums[l] && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                r--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchinRotatedSortedArrayII test = new SearchinRotatedSortedArrayII();
        int[] nums = new int[]{3,1,1};
        System.out.println(test.search(nums, 3));
    }
}