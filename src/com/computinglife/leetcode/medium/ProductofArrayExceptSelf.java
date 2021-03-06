/*Given an array of n integers where n > 1, nums, return an array output
        such that output[i] is equal to the product of all the elements of nums except nums[i].

        Solve it without division and in O(n).

        For example, given [1,2,3,4], return [24,12,8,6].

        Follow up:
        Could you solve it with constant space complexity?
        (Note: The output array does not count as extra space for the purpose of space complexity analysis.)*/

package com.computinglife.leetcode.medium;

/**
 * Created by YanceyLiu on 3/2/2016.
 */
public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        //两次，分别正向和逆向遍历一次数组即可
        int left = 1;
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length - 1; i++) {
            left *= nums[i];
            //result[i + 1] == 0 ? result[i + 1] = left : result[i + 1] *= left;
            if (result[i + 1] == 0) {
                result[i + 1] = left;
            } else {
                result[i + 1] *= left;
            }
        }
        int right = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            right *= nums[i];
            if (result[i - 1] == 0) {
                result[i - 1] = right;
            } else {
                result[i - 1] *= right;
            }
        }
        return result;
    }
}
