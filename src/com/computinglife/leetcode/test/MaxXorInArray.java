package com.computinglife.leetcode.test;

/**
 * Created by YanceyLiu on 5/19/2016.
 */
public class MaxXorInArray {

    public int findMaxBruteForce(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int tmp = 0;
            for (int j = i; j < nums.length; j++) {
                tmp = tmp ^ nums[j];
                max = Math.max(max, tmp);
            }
        }
        return max;
    }



    public static void main(String[] args) {
        MaxXorInArray test = new MaxXorInArray();
        int[] nums = {8, 1, 2, 12};
        System.out.println(test.findMaxBruteForce(nums));
    }

}
