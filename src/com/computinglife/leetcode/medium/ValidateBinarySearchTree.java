/*Given a binary tree, determine if it is a valid binary search tree (BST).

        Assume a BST is defined as follows:

        The left subtree of a node contains only nodes with keys less than the node's key.
        The right subtree of a node contains only nodes with keys greater than the node's key.
        Both the left and right subtrees must also be binary search trees.*/

package com.computinglife.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by youngliu on 12/30/15.
 */
public class ValidateBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBSTWrong(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(null, root, null);
    }

    public boolean helper(TreeNode lFather, TreeNode node, TreeNode rFather) {
        if (node == null) {
            return true;
        }
        if (node.left != null && node.val <= node.left.val) {
            return false;
        }
        if (lFather != null && node.left != null && node.left.val <= lFather.val) {
            return false;
        }
        if (node.right != null && node.val >= node.right.val) {
            return false;
        }
        if (rFather != null && node.right != null && node.right.val >= rFather.val) {
            return false;
        }
        return helper(null, node.left, node) && helper(node, node.right, null);
    }

    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        List<Integer> seq = new ArrayList<>();
        helper2(root, seq);
        for(int i = 0;i<seq.size()-1;i++){
            if(seq.get(i)>=seq.get(i+1))
                return false;
        }
        return true;
    }

    public void helper2(TreeNode node, List<Integer> seq) {
        if (node != null) {
            helper2(node.left, seq);
            seq.add(node.val);
            helper2(node.right, seq);
        }
    }
}
