//Given a binary tree, determine if it is height-balanced.
//
//        For this problem, a height-balanced binary tree is defined as a binary tree in which
//        the depth of the two subtrees of every node never differ by more than 1.

package com.computinglife.leetcode.easy;

/**
 * Created by Young on 2015/10/4.
 */
public class BalancedBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(maxDeepTree(root.left) - maxDeepTree(root.right)) > 1) {
            return false;
        }
        if (!isBalanced(root.left)) return false;
        if (!isBalanced(root.right)) return false;
        return true;
    }

    public int maxDeepTree(TreeNode node) {
        int deep = 0;
        if (node == null) {
            return 0;
        } else {
            deep = 1;
        }
        int left = maxDeepTree(node.left);
        int right = maxDeepTree(node.right);
        deep += left > right ? left : right;
        return deep;
    }

}
