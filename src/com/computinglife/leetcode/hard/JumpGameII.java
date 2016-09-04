package com.computinglife.leetcode.hard;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p>
 * For example:
 * Given array A = [2,3,1,1,4]
 * <p>
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * <p>
 * Note:
 * You can assume that you can always reach the last index.
 * Created by yliu on 9/3/16.
 */
public class JumpGameII {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1; //illegal input parameter
        }
        if (nums.length == 1) {
            return 0;
        }
        int level = 0, currentMax = 0, nextMax = 0, i = 0;
        while (currentMax - i + 1 > 0) {
            level++;
            for (; i <= currentMax; i++) {
                nextMax = Math.max(nextMax, nums[i] + i);
                if (nextMax >= nums.length - 1) {
                    return level;
                }
            }
            currentMax = nextMax;
        }
        return -1;
    }

    public static void main(String[] args) {
        JumpGameII test = new JumpGameII();
        int[] nums = {1, 2, 1, 1, 1};
        System.out.println(test.jump(nums));
    }
}
