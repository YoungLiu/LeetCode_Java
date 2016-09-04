package com.computinglife.leetcode.hard;

/**
 * Created by yliu on 8/20/16.
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int count = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                count += leftMax - height[left];
                left++;
            } else {
                count += rightMax - height[right];
                right--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        TrappingRainWater test = new TrappingRainWater();
        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(test.trap(nums));
    }
}
