/*Find the contiguous subarray within an array (containing at least one number) which has the largest product.

        For example, given the array [2,3,-2,4],
        the contiguous subarray [2,3] has the largest product = 6.*/

package com.computinglife.leetcode.medium;

/**
 * Created by youngliu on 1/29/16.
 */
public class MaximumProductSubarray {

    //暴力方法
    public int maxProduct2(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int product = calculate(nums, i, j);
                max = Math.max(max, product);
            }
        }
        return max;
    }


    public int calculate(int[] nums, int i, int j) {
        int result = 1;
        for (int x = i; x <= j; x++) {
            result *= nums[x];
        }
        return result;
    }

    //DP
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxLocal = nums[0];
        int minLocal = nums[0];
        int global = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tmp = maxLocal;
            maxLocal = Math.max(Math.max(maxLocal * nums[i], nums[i]), nums[i] * minLocal);
            minLocal = Math.min(Math.min(tmp * nums[i], nums[i]), nums[i] * minLocal);
            global = Math.max(maxLocal, global);
        }
        return global;
    }

    public static void main(String[] args) {
        MaximumProductSubarray test = new MaximumProductSubarray();
        int[] nums = new int[]{2, 3, -2, -9, 4};
        System.out.println(test.maxProduct2(nums));
    }
}
