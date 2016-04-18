/*Suppose a sorted array is rotated at some pivot unknown to you beforehand.

        (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

        You are given a target value to search. If found in the array return its index, otherwise return -1.

        You may assume no duplicate exists in the array.*/

package com.computinglife.leetcode.hard;

/**
 * Created by youngliu on 12/22/15.
 */
public class SearchinRotatedSortedArray {
    //low爆了
    public int searchBack(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i])
                return i;
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        int m;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] == target) {
                return m;
            }
            if (nums[m] < nums[r]) {
                //右部有序
                if (target > nums[m] && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                //左部有序
                if (target >= nums[l] && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        return -1;
    }

}
