/*
Given a binary tree, return the inorder traversal of its nodes' values.

        For example:
        Given binary tree {1,#,2,3},
        1
        \
        2
        /
        3
        return [1,3,2].

        Note: Recursive solution is trivial, could you do it iteratively?

*/
package com.computinglife.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by youngliu on 12/27/15.
 */
public class BinaryTreeInorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
