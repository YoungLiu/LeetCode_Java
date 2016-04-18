/*Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
        The algorithm should run in linear time and in O(1) space.

        Hint:

        How many majority elements could it possibly have?*/

package com.computinglife.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YanceyLiu on 2/28/2016.
 */
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Integer n1 = null, n2 = null;
        int c1 = 0, c2 = 0;
        for (int tmp : nums) {
            if (n1 != null && tmp == n1.intValue()) {
                c1++;
            } else if (n2 != null && tmp == n2.intValue()) {
                c2++;
            } else if (c1 == 0) {
                n1 = tmp;
                c1 = 1;
            } else if (c2 == 0) {
                n2 = tmp;
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }
        c1 = c2 = 0;
        for (int tmp : nums) {
            if (tmp == n1.intValue()) {
                c1++;
            } else if (tmp == n2.intValue()) {
                c2++;
            }
        }

        if (c1 > nums.length / 3) {
            result.add(n1);
        }
        if (c2 > nums.length / 3) {
            result.add(n2);
        }
        return result;
    }
}
