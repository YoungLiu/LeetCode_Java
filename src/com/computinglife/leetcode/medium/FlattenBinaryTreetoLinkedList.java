/*Given a binary tree, flatten it to a linked list in-place.

        For example,
        Given

            1
           / \
          2   5
         / \   \
        3   4   6
        The flattened tree should look like:
        1
         \
          2
           \
            3
             \
              4
               \
                5
                 \
                  6*/

package com.computinglife.leetcode.medium;

/**
 * Created by youngliu on 1/4/16.
 */
public class FlattenBinaryTreetoLinkedList {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.right = left;
            root.left = null;
            while (left.right != null) {
                left = left.right;
            }
            left.right = right;
        }
        flatten(root.right);
    }
}
