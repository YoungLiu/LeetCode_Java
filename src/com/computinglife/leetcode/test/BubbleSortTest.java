package com.computinglife.leetcode.test;

/**
 * Created by youngliu on 1/28/16.
 */
public class BubbleSortTest {

    public void bubbleSortTest(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSortTest test = new BubbleSortTest();
        int[] nums = new int[]{5, 4, 3, 2, 1};
        test.bubbleSortTest(nums);
        for (int tmp : nums) {
            System.out.println(tmp);
        }
    }
}
