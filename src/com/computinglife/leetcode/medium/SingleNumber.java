/*Given an array of integers, every element appears twice except for one. Find that single one.

        Note:
        Your algorithm should have a linear runtime complexity.
        Could you implement it without using extra memory?*/

package com.computinglife.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by youngliu on 1/21/16.
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (int tmp : nums) {
            if (numsSet.contains(tmp)) {
                numsSet.remove(tmp);
            } else {
                numsSet.add(tmp);
            }
        }

        Integer[] res = numsSet.toArray(new Integer[numsSet.size()]);
        return res[0];
    }

    public static void main(String[] args) {
        SingleNumber test = new SingleNumber();
        int[] nums = {3, 6, 3, 6, 7, 1, 9, 8, 8, 7, 9};
        System.out.println(test.singleNumber(nums));
    }
}
