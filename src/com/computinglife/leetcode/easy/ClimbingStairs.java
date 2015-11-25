//You are climbing a stair case. It takes n steps to reach to the top.
//
//        Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

package com.computinglife.leetcode.easy;

/**
 * Created by Young on 2015/10/6.
 */
public class ClimbingStairs {
	// 此递归方法超出了运算判定时间限制
	public int climbStairs_Time_Limit_Exceeded(int n) {
		int[] resource = { 0, 1, 2 };
		if (n <= 2) {
			return resource[n];
		}
		return climbStairs_Time_Limit_Exceeded(n - 1) + climbStairs_Time_Limit_Exceeded(n - 2);
	}

	// 递推法(从前往后递推)
	public int climbStairs(int n) {
		int[] dp = { 1, 1, 0 };
		if (n < 2) {
			return 1;
		}
		for (int i = 2; i <= n; i++) {
			dp[2] = dp[0] + dp[1];
			dp[0] = dp[1];
			dp[1] = dp[2];
		}
		return dp[2];
	}
}
