/*Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

        Formally the function should:
        Return true if there exists i, j, k
        such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
        Your algorithm should run in O(n) time complexity and O(1) space complexity.

        Examples:
        Given [1, 2, 3, 4, 5],
        return true.

        Given [5, 4, 3, 2, 1],
        return false.

        Credits:
        Special thanks to @DjangoUnchained for adding this problem and creating all test cases.*/

package com.computinglife.leetcode.medium;

/**
 * Created by YanceyLiu on 5/2/2016.
 */
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] <= nums[i]) {
                    continue;
                }
                for (int z = j + 1; z < nums.length; z++) {
                    if (nums[z] <= nums[j]) {
                        continue;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public boolean increasingTriplet2(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int one = Integer.MAX_VALUE;
        int two = Integer.MAX_VALUE;
        for (int tmp : nums) {
            if (tmp <= one) {
                one = tmp;
            } else if (tmp > one && tmp <= two) {
                two = tmp;
            } else if (tmp > two && two < Integer.MAX_VALUE) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IncreasingTripletSubsequence test = new IncreasingTripletSubsequence();
        int[] nums = {5, 4, 3, 2, 1};
        System.out.println(test.increasingTriplet(nums));
    }
}
