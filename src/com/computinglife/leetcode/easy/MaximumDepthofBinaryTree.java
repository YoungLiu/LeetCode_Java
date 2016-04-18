//Given a binary tree, find its maximum depth.
//
//        The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

package com.computinglife.leetcode.easy;

/**
 * Created by Young on 2015/10/4.
 */
public class MaximumDepthofBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        int deep = 0;
        if (root == null) {
            return 0;
        } else {
            deep = 1;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        deep += left > right ? left : right;
        return deep;
    }
}
