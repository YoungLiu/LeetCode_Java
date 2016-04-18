/*Find the kth largest element in an unsorted array.
        Note that it is the kth largest element in the sorted order,
        not the kth distinct element.

        For example,
        Given [3,2,1,5,6,4] and k = 2, return 5.

        Note:
        You may assume k is always valid, 1 ≤ k ≤ array's length.*/

package com.computinglife.leetcode.medium;

import java.util.Arrays;

/**
 * Created by youngliu on 2/24/16.
 */
public class KthLargestElementinanArray {
    public int findKthLargest2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums == null) {
            throw new IllegalArgumentException("illegal argument exception");
        }
        return findK(nums, nums.length - k, 0, nums.length - 1);
    }

    private int findK(int[] nums, int k, int i, int j) {
        if (i >= j) {
            return nums[i];
        }
        int m = partition(nums, i, j);
        if (k == m) {
            return nums[m];
        } else if (k < m) {
            return findK(nums, k, i, m - 1);
        } else {
            return findK(nums, k, m + 1, j);
        }
    }

    private int partition(int[] nums, int i, int j) {
        int pivot = nums[i];
        int m = i;
        int n = i + 1;
        while (n <= j) {
            if (nums[n] < pivot) {
                swap(nums, ++m, n);
            }
            n++;
        }
        swap(nums, i, m);
        return m;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
