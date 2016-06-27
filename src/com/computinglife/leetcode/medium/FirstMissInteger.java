package com.computinglife.leetcode.medium;

/**
 * Created by yliu on 6/26/16.
 */
public class FirstMissInteger {
    public int firstMissingPositive(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 1;
        }
        int n = A.length;
        for (int i = 0; i < n; ) {
            if (A[i] == i + 1) {
                i++;
            } else {
                if (A[i] >= 1 && A[i] <= n && A[A[i] - 1] != A[i]) {
                    swap(A, A[i] - 1, i);
                } else {
                    i++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void main(String[] args) {
        FirstMissInteger test = new FirstMissInteger();
        int[] nums = {3, 4, -1, 1};
        System.out.printf(test.firstMissingPositive(nums) + "");
    }
}
