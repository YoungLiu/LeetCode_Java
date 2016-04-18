/*Follow up for "Remove Duplicates":
        What if duplicates are allowed at most twice?

        For example,
        Given sorted array nums = [1,1,1,2,2,3],

        Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3.
        It doesn't matter what you leave beyond the new length.*/

package com.computinglife.leetcode.medium;

/**
 * Created by youngliu on 12/21/15.
 */
public class RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                count++;
                if (count > 2) {
                    continue;
                }
            } else {
                count = 1;
            }
            nums[index++] = nums[i];
        }
        return index;
    }

    public static void main(String[] args) {
        RemoveDuplicatesfromSortedArrayII test = new RemoveDuplicatesfromSortedArrayII();
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(test.removeDuplicates(nums));
        System.out.println(nums);
    }
}
