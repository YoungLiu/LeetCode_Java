/*Given an unsorted array of integers, find the length of longest increasing subsequence.

        For example,
        Given [10, 9, 2, 5, 3, 7, 101, 18],
        The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4.
        Note that there may be more than one LIS combination, it is only necessary for you to return the length.

        Your algorithm should run in O(n2) complexity.

        one:  dp[i] 为 以 A[i]结尾的LIS，那么对于dp[i]有dp[i] =max( dp[j] + 1) [ 0<= j < i, nums[j] < nums[i]  ]

        Follow up: Could you improve it to O(n log n) time complexity?*/

package com.computinglife.leetcode.medium;

/**
 * Created by YanceyLiu on 5/12/2016.
 */
public class LongestIncreasingSubsequence {

    private static int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};

    //o(n^2)
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int target = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && target < dp[j] + 1) {
                    target = dp[j] + 1;
                }
            }
            dp[i] = target;
            if (res < target) {
                res = target;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence test = new LongestIncreasingSubsequence();
        System.out.println(test.test());
    }

    private int test() {
        Solution so = new Solution();
        return so.lengthOfLIS(nums);
    }

    class Solution {

        //O(nlog(n))
        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int len = 0;
            int[] tails = new int[nums.length];
            tails[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < tails[0]) {
                    tails[0] = nums[i];
                } else if (nums[i] >= tails[len]) {
                    tails[++len] = nums[i];
                } else {
                    //binary search
                    tails[binarySearch(0, len, tails, nums[i])] = nums[i];
                }
            }
            return len + 1;
        }

        private int binarySearch(int start, int end, int[] tails, int target) {
            while (start <= end) {
                int mid = (start + end) >> 1;
                if (tails[mid] == target) {
                    return mid;
                } else if (tails[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return start;
        }
    }
}
