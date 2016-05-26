/*Given two arrays, write a function to compute their intersection.

        Example:
        Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

        Note:
        Each element in the result should appear as many times as it shows in both arrays.
        The result can be in any order.
        Follow up:
            What if the given array is already sorted? How would you optimize your algorithm?
            What if nums1's size is small compared to num2's size? Which algorithm is better?
            What if elements of nums2 are stored on disk, and the memory is limited
            such that you cannot load all elements into the memory at once?*/

package com.computinglife.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YanceyLiu on 5/26/2016.
 */
public class IntersectionofTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        int[] tmp = nums1.length > nums2.length ? nums1 : nums2;
        for (int element : tmp) {
            if (map.containsKey(element)) {
                map.put(element, map.get(element) + 1);
            } else {
                map.put(element, 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        tmp = nums1.length > nums2.length ? nums2 : nums1;
        for (int element : tmp) {
            if (map.containsKey(element)) {
                res.add(element);
                int count = map.get(element) - 1;
                if (count == 0) {
                    map.remove(element);
                } else {
                    map.put(element, count);
                }
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
