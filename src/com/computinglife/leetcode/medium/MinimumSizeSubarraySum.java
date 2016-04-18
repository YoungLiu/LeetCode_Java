/*Given an array of n positive integers and a positive integer s,
        find the minimal length of a subarray of which the sum ≥ s.
        If there isn't one, return 0 instead.

        For example, given the array [2,3,1,2,4,3] and s = 7,
        the subarray [4,3] has the minimal length under the problem constraint.

        click to show more practice.

        More practice:
        If you have figured out the O(n) solution,
        try coding another solution of which the time complexity is O(n log n).*/

package com.computinglife.leetcode.medium;

/**
 * Created by youngliu on 2/21/16.
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLenBack(int s, int[] nums) {
        if (s == 0) {
            return 0;
        }
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int tmp = i;
            int count = nums[tmp];
            while (count < s && tmp < len - 1) {
                count += nums[++tmp];
            }
            if (count >= s) {
                min = Math.min(min, tmp - i + 1);
            }
        }
        return min;
    }

    public int minSubArrayLen(int s, int[] nums) {
        if (s == 0) {
            return 0;
        }
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = nums.length;
        int i = 0;
        int sum = nums[0];
        for (int j = 0; j < nums.length; ) {
            if (i == j) {
                if (nums[i] >= s) {
                    return 1;
                } else {
                    j++;
                    if (j < nums.length) {
                        sum += nums[j];
                    } else {
                        if (i == 0) {
                            return 0;
                        } else {
                            return result;
                        }
                    }
                }
            } else {
                if (sum >= s) {
                    result = Math.min(j - i + 1, result);
                    sum -= nums[i];
                    i++;
                } else {
                    j++;
                    if (j < nums.length) {
                        sum += nums[j];
                    } else {
                        if (i == 0) {
                            return 0;
                        } else {
                            return result;
                        }
                    }
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        MinimumSizeSubarraySum test = new MinimumSizeSubarraySum();
        int[] nums = {1};
        System.out.println(test.minSubArrayLen(2, nums));
    }
}
