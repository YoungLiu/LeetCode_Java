/*Given two arrays, write a function to compute their intersection.

        Example:
        Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

        Note:
        Each element in the result must be unique.
        The result can be in any order.*/

package com.computinglife.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by YanceyLiu on 5/26/2016.
 */
public class IntersectionofTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> res = new HashSet<>();
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        int[] tmp = nums1.length > nums2.length ? nums1 : nums2;
        Set<Integer> table = new HashSet<>();
        for (int element : tmp) {
            table.add(element);
        }
        tmp = nums1.length > nums2.length ? nums2 : nums1;
        for (int element : tmp) {
            if (table.contains(element)) {
                res.add(element);
            }
        }
        int[] result = new int[res.size()];
        int i = 0;
        for (int element : res) {
            result[i++] = element;
        }
        return result;
    }
}
