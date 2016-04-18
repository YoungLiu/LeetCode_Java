/*Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
        with the colors in the order red, white and blue.

        Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

        Note:
        You are not suppose to use the library's sort function for this problem.

        Follow up:
        A rather straight forward solution is a two-pass algorithm using counting sort.
        First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's,
        then 1's and followed by 2's.

        Could you come up with an one-pass algorithm using only constant space?*/

package com.computinglife.leetcode.medium;

/**
 * Created by youngliu on 12/18/15.
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int current = start;
        int tmp = 0;
        while (current <= end) {
            if (nums[current] == 0) {
                //红色：与start交换，并向前移一位
                tmp = nums[start];
                nums[start] = nums[current];
                nums[current] = tmp;
                start++;
                current++;
            } else if (nums[current] == 1) {
                //白色：向前移一位
                current++;
            } else if (nums[current] == 2) {
                //蓝色:end互换，但是不移位
                tmp = nums[end];
                nums[end] = nums[current];
                nums[current] = tmp;
                end--;
            }
        }
    }

    public static void main(String[] args) {
        SortColors test = new SortColors();
        int[] nums = new int[]{2, 0, 1, 1, 0, 0, 2, 1, 0};
        test.sortColors(nums);
        for (int tmp : nums) {
            System.out.print(tmp + ",");
        }
    }
}
