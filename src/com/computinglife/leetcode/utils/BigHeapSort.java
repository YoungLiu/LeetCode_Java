package com.computinglife.leetcode.utils;

/**
 * Created by yliu on 8/7/16.
 */
public class BigHeapSort {

    public static void main(String[] args) {
        int[] nums = new int[]{16, 7, 3, 20, 17, 8};
        bigHeapSort(nums, nums.length - 1);
        for (int tmp : nums) {
            System.out.print(tmp);
            System.out.print(" ");
        }
    }

    public static void bigHeapSort(int[] nums, int size) {
        buildBigHeap(nums, size);
        for (int i = size; i >= 0; i--) {
            swap(nums, 0, i);
            bigHeapAdjust(nums, 0, i - 1);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        return;
    }

    public static void buildBigHeap(int[] nums, int size) {
        for (int i = size / 2; i >= 0; i--) {
            bigHeapAdjust(nums, i, size);
        }
        return;
    }

    public static void bigHeapAdjust(int[] nums, int i, int size) {
        int lChild = 2 * i;
        int rChild = 2 * i + 1;
        int max = i;
        if (i <= size / 2) {
            if (lChild <= size && nums[lChild] > nums[max]) {
                max = lChild;
            }
            if (rChild <= size && nums[rChild] > nums[max]) {
                max = rChild;
            }
            if (max != i) {
                swap(nums, max, i);
                bigHeapAdjust(nums, max, size);
            }
        }
    }

}