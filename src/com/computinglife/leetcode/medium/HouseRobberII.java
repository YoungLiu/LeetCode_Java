/*Note: This is an extension of House Robber.
        After robbing those houses on that street, the thief has found himself a new place for his thievery
        so that he will not get too much attention. This time, all houses at this place are arranged in a circle.
        That means the first house is the neighbor of the last one.
        Meanwhile, the security system for these houses remain the same as for those in the previous street.

        Given a list of non-negative integers representing the amount of money of each house,
        determine the maximum amount of money you can rob tonight without alerting the police.*/

package com.computinglife.leetcode.medium;

/**
 * Created by youngliu on 2/23/16.
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        //include 1st element,but not last element
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        //include last element,but not 1st
        int[] dr = new int[len + 1];
        dp[0] = 0;
        dp[1] = nums[1];
        for (int i = 2; i < len; i++) {
            dr[i] = Math.max(dr[i - 1], dr[i - 2] + nums[i]);
        }
        return Math.max(dp[len - 1], dr[len - 1]);
    }
}
