//You are a professional robber planning to rob houses along a street.
//        Each house has a certain amount of money stashed,
//        the only constraint stopping you from robbing each of them is that
//        adjacent houses have security system connected and it will automatically contact the police
//        if two adjacent houses were broken into on the same night.
//
//        Given a list of non-negative integers representing the amount of money of each house,
//        determine the maximum amount of money you can rob tonight without alerting the police.

package com.computinglife.leetcode.easy;

/**
 * Created by Young on 2015/9/18.
 */
public class HouseRobber {
    public int rob(int[] nums) {
        int preRob = 0;
        int preNotRob = 0;
        int rob = 0;
        int notRob = 0;
        for (int tmp : nums) {
            rob = preNotRob + tmp;
            notRob = Math.max(preRob, preNotRob);
            preRob = rob;
            preNotRob = notRob;
        }
        return Math.max(rob, notRob);
    }

    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        HouseRobber test = new HouseRobber();
        int[] nums = {50, 50, 60, 60};
        System.out.println(test.rob(nums));
    }
}
