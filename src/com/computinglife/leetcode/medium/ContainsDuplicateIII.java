/*Given an array of integers, find out whether there are two distinct indices i and j in the array
        such that the difference between nums[i] and nums[j] is at most t
        and the difference between i and j is at most k.*/

package com.computinglife.leetcode.medium;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by youngliu on 2/25/16.
 */
public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) {
            return false;
        }
        SortedSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long leftBoundary = (long) nums[i] - t;
            long rightBoundary = (long) nums[i] + t + 1;
            SortedSet<Long> subSet = set.subSet(leftBoundary, rightBoundary);
            if (!subSet.isEmpty()) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}
