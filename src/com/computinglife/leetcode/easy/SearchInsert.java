package com.computinglife.leetcode.easy;

/**
 * Created by yliu on 7/2/16.
 */
public class SearchInsert {
    public static int searchInsert(int[] A, int target) {
        // write your code here
        if(A == null || A.length == 0){
            return 0;
        }
        int start = 0;
        int end = A.length - 1;
        while (start < end){
            int mid = (start + end) / 2;
            if(A[mid] == target){
                return mid;
            } else if (A[mid] < target){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (A[start] > target) {
            if(start == 0){
                return 0;
            }
            return start - 1;
        } else if(A[start] == target) {
            return start;
        } else {
            if(start == A.length - 1){
                return A.length;
            }
            return start + 1;
        }
    }

    public static void main(String[] args){
        int[] nums = {1,2};
        int target = 14640;
        int ret = searchInsert(nums, target);
        System.out.println(ret);
    }
}
