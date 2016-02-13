/*A peak element is an element that is greater than its neighbors.

        Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

        The array may contain multiple peaks,
        in that case return the index to any one of the peaks is fine.

        You may imagine that num[-1] = num[n] = -∞.

        For example, in array [1, 2, 3, 1],
        3 is a peak element and your function should return the index number 2.*/

package com.computinglife.leetcode.medium;

/**
 * Created by youngliu on 2/13/16.
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int start, int end) {
        if (start == end) {
            return start;
        }

        int mid = (start + end) / 2;
        if (nums[mid] > nums[mid + 1]) {
            return helper(nums, start, mid);
        } else {
            return helper(nums, mid + 1, end);
        }
    }

    //此题的假设是在两端都为负无穷的情况下的，所以右侧总会有趋于下降的区段，左侧也是如此
    public static void main(String[] args) {
        FindPeakElement test = new FindPeakElement();
        int[] nums = {1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        System.out.println(test.findPeakElement(nums));
    }
}
