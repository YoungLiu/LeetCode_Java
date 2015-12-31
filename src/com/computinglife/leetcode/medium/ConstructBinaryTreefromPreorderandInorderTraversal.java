/*Given preorder and inorder traversal of a tree, construct the binary tree.

        Note:
        You may assume that duplicates do not exist in the tree.*/

package com.computinglife.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by youngliu on 12/31/15.
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        if (preorder.length != inorder.length) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    public TreeNode helper(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR, Map<Integer, Integer> map) {
        if (preL > preR || inL > inR) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preL]);
        int index = map.get(preorder[preL]);
        //关键在于左右递归时定点区间的选取
        root.left = helper(preorder, preL + 1, index - inL + preL, inorder, inL, index - 1, map);
        root.right = helper(preorder, index - inL + preL + 1, preR, inorder, index + 1, inR, map);
        return root;
    }
}
