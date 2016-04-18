/*Given an array where elements are sorted in ascending order,
        convert it to a height balanced BST.*/

package com.computinglife.leetcode.medium;

/**
 * Created by youngliu on 1/1/16.
 */
public class ConvertSortedArraytoBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int rootIndex = (start + end) / 2;
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = helper(nums, start, rootIndex - 1);
        root.right = helper(nums, rootIndex + 1, end);
        return root;
    }
}
