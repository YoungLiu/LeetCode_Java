package com.computinglife.leetcode.exam;

/**
 * Created by yliu on 8/23/16.
 */
public class BinarySearch {

    // the recursion method
    public static boolean binarySearch(int array[], int low, int high, int target) {
        if (array == null || array.length == 0) {
            return false;
        }

        if (low > high)
            return false;

        int mid = (low + high) >>> 1;
        if (array[mid] > target) {
            return binarySearch(array, low, mid - 1, target);
        } else if (array[mid] < target) {
            return binarySearch(array, mid + 1, high, target);
        } else {
            return true;
        }
    }

    //the non-recursive method
    public static boolean binarySearchWithoutRecursion(int array[], int low, int high, int target) {
        if (array == null || array.length == 0) {
            return false;
        }

        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (array[mid] > target) {
                high = mid - 1;
            } else if (array[mid] < target) {
                low = mid + 1;
            } else {
                //find the target
                return true;
            }
        }
        //the array does not contain the target
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        System.out.printf("our array is nums-->{1,2,3,4,5,6}\n");
        System.out.printf("the recursion method result:\n");
        System.out.printf("is 7 in nums? %s\n", binarySearch(nums, 0, nums.length - 1, 7));
        System.out.printf("is 2 in nums? %s\n", binarySearch(nums, 0, nums.length - 1, 2));
        System.out.printf("is 1 in nums? %s\n", binarySearch(nums, 0, nums.length - 1, 1));
        System.out.printf("is 0 in nums? %s\n", binarySearch(nums, 0, nums.length - 1, 0));
        System.out.printf("the non-recursive method result:\n");
        System.out.printf("is 7 in nums? %s\n", binarySearchWithoutRecursion(nums, 0, nums.length - 1, 7));
        System.out.printf("is 2 in nums? %s\n", binarySearchWithoutRecursion(nums, 0, nums.length - 1, 2));
        System.out.printf("is 1 in nums? %s\n", binarySearchWithoutRecursion(nums, 0, nums.length - 1, 1));
        System.out.printf("is 0 in nums? %s\n", binarySearchWithoutRecursion(nums, 0, nums.length - 1, 0));
        int[] illegalTest = {};
        System.out.println("our illegal test case is {}, a empty array");
        System.out.printf("illegal test result is %s", binarySearch(nums, 0, nums.length - 1, 100));
    }
}
