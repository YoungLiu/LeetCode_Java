/*
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

        The update(i, val) function modifies nums by updating the element at index i to val.
        Example:
        Given nums = [1, 3, 5]

        sumRange(0, 2) -> 9
        update(1, 2)
        sumRange(0, 2) -> 8
        Note:
        The array is only modifiable by the update function.
        You may assume the number of calls to update and sumRange function is distributed evenly.
*/

package com.computinglife.leetcode.medium;

/**
 * Created by YanceyLiu on 5/10/2016.
 */
public class RangeSumQueryMutable {

    private int[] nums;
    private int[] segmentTree;
    private int n;

    public RangeSumQueryMutable(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        segmentTree = new int[2 * n];
        for (int i = n, j = 0; i < 2 * n; i++, j++) {
            segmentTree[i] = nums[j];
        }
        for (int i = n - 1; i > 0; i--) {
            segmentTree[i] = segmentTree[2 * i] + segmentTree[2 * i + 1];
        }
    }

    void update(int i, int val) {
        int pos = n + i;
        segmentTree[pos] = val;
        while (pos > 0) {
            int left = pos;
            int right = pos;
            if ((pos & 1) == 0) {
                //even
                right++;
            } else {
                //odd
                left--;
            }
            segmentTree[pos / 2] = segmentTree[left] + segmentTree[right];
            pos /= 2;
        }
    }

    public int sumRange(int i, int j) {
        i += n;
        j += n;
        int sum = 0;
        while (i <= j) {
            if ((i & 1) != 0) {
                //odd
                sum += segmentTree[i];
                i++;
            }
            if ((j & 1) == 0) {
                //even
                sum += segmentTree[j];
                j--;
            }
            i /= 2;
            j /= 2;
        }
        return sum;
    }
}
