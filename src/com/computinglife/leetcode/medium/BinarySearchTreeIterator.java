/*Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

        Calling next() will return the next smallest number in the BST.

        Note: next() and hasNext() should run in average O(1) time and uses O(h) memory,
        where h is the height of the tree.*/

package com.computinglife.leetcode.medium;

import java.util.Stack;

/**
 * Created by youngliu on 2/14/16.
 */
public class BinarySearchTreeIterator {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private Stack<TreeNode> stack = new Stack<>();

    public BinarySearchTreeIterator(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode node = stack.pop();
        int res = node.val;
        if (node.right != null) {
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        return res;
    }
}
