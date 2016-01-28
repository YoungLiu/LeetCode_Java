/*Given a binary tree, return the preorder traversal of its nodes' values.

        For example:
        Given binary tree {1,#,2,3},
          1
           \
            2
           /
          3
        return [1,2,3].

        Note: Recursive solution is trivial, could you do it iteratively?*/

package com.computinglife.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by youngliu on 1/27/16.
 */
public class BinaryTreePreorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode node, List<Integer> res) {
        if (node != null) {
            res.add(node.val);
            helper(node.left, res);
            helper(node.right, res);
        }
    }

    //用stack解决递归调用的问题
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
        return res;
    }

}
