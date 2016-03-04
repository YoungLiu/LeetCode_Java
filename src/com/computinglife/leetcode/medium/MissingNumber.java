/*Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

        For example,
        Given nums = [0, 1, 3] return 2.

        Note:
        Your algorithm should run in linear runtime complexity.
        Could you implement it using only constant extra space complexity?*/

package com.computinglife.leetcode.medium;

/**
 * Created by YanceyLiu on 3/4/2016.
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int[] nums2 = new int[nums.length + 1];
        for (int i = 0; i < nums2.length; i++) {
            nums2[i] = i;
        }
        for (int i = 0; i < nums.length; i++) {
            nums2[nums[i]] = -1;
        }
        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] != -1) {
                return i;
            }
        }
        return -1;
    }
}
