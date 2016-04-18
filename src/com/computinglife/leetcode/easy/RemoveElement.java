//Given an array and a value, 
//remove all instances of that value in place and return the new length.
//
//The order of elements can be changed. 
//It doesn't matter what you leave beyond the new length.

package com.computinglife.leetcode.easy;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                length--;
                if (length == 0) {
                    return length;
                }
                if (i == length) {
                    return length;
                }
                for (int j = i; j < length; j++) {
                    nums[j] = nums[j + 1];
                }
                if (i == nums.length - 1) {
                    break;
                }
                i--;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        RemoveElement test = new RemoveElement();
        int[] nums = {4, 5, 5};
        System.out.println(test.removeElement(nums, 5));
    }
}
