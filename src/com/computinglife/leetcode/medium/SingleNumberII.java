/*Given an array of integers, every element appears three times except for one. Find that single one.

        Note:
        Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?*/

package com.computinglife.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by youngliu on 1/22/16.
 */
public class SingleNumberII {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int tmp : nums) {
            if (numsMap.containsKey(tmp)) {
                if (numsMap.get(tmp) >= 2) {
                    numsMap.remove(tmp);
                } else {
                    numsMap.put(tmp, numsMap.get(tmp) + 1);
                }
            } else {
                numsMap.put(tmp, 1);
            }
        }

        Integer[] res = numsMap.keySet().toArray(new Integer[numsMap.keySet().size()]);
        return res[0];
    }

    public static void main(String[] args) {
        SingleNumberII test = new SingleNumberII();
        int[] nums = {2, 4, 3, 4, 3, 1, 2, 3, 2, 4};
        System.out.println(test.singleNumber(nums));
    }
}
