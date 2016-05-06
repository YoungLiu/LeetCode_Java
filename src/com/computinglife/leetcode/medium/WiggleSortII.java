/*Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

        Example:
        (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
        (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].

        Note:
        You may assume all input has valid answer.

        Follow Up:
        Can you do it in O(n) time and/or in-place with O(1) extra space?*/

package com.computinglife.leetcode.medium;

import java.util.Arrays;

/**
 * Created by YanceyLiu on 5/3/2016.
 */
public class WiggleSortII {
    public void wiggleSort2(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        Arrays.sort(nums);
        int front = 1;
        int end = nums.length - 1;
        while (front < end) {
            int tmp = nums[front];
            nums[front] = nums[end];
            nums[end] = tmp;
            front += 2;
            end -= 2;
        }
    }

    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        Arrays.sort(nums);
        int s = (nums.length + 1) >> 1;
        int t = nums.length;
        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tmp[i] = (i & 1) == 0 ? nums[--s] : nums[--t];
        }
        for(int i = 0;i<nums.length;i++){
            nums[i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        WiggleSortII test = new WiggleSortII();
        int[] nums = {1, 5, 1, 1, 6, 4};
        test.wiggleSort(nums);
        for (int tmp : nums) {
            System.out.println(tmp);
        }
    }
}
