/*Given an array of numbers nums,
        in which exactly two elements appear only once and all the other elements appear exactly twice.
        Find the two elements that appear only once.

        For example:

        Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

        Note:
        The order of the result is not important. So in the above example, [5, 3] is also correct.
        Your algorithm should run in linear runtime complexity.
        Could you implement it using only constant space complexity?*/

package com.computinglife.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YanceyLiu on 3/3/2016.
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return null;
        }
        int xor = nums[0];
        for (int i = 1; i < nums.length; i++) {
            xor ^= nums[i];
        }
        int lowBit = xor & (-xor);
        int flag = 0;
        for (int tmp : nums) {
            flag = tmp & lowBit;
            if (flag == 0) {
                res[0] ^= tmp;
            } else {
                res[1] ^= tmp;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SingleNumberIII test = new SingleNumberIII();
        int[] nums = {2, 1, 2, 3, 4, 1};
        int[] res = test.singleNumber(nums);
        for (int tem : res) {
            System.out.println(tem);
        }
    }
}
