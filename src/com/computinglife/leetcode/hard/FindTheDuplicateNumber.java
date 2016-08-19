package com.computinglife.leetcode.hard;

/**
 * Created by yliu on 8/19/16.
 */
public class FindTheDuplicateNumber {
    public static int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 1;
        int high = nums.length - 1;  // the length is n + 1, so this is n, we subtract one
        while (low <= high) {
            int mid = (low + high) / 2;
            //int mid = (int) (low + (high - low) * 0.5);
            int count = 0;
            for (int tmp : nums) {
                if (tmp <= mid) {
                    count++;
                }
            }
            if (count <= mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(findDuplicate(nums));
    }
}
