/*Given inorder and postorder traversal of a tree, construct the binary tree.

        Note:
        You may assume that duplicates do not exist in the tree.*/

package com.computinglife.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by youngliu on 12/31/15.
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) {
            return null;
        }
        if (inorder.length != postorder.length) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }

    public TreeNode helper(int[] inorder, int inL, int inR, int[] postorder, int postL, int postR, Map<Integer, Integer> map) {
        if (inL > inR || postL > postR) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postR]);
        int index = map.get(postorder[postR]);
        root.left = helper(inorder, inL, index - 1, postorder, postL, postL + index - inL - 1, map);
        root.right = helper(inorder, index + 1, inR, postorder, postL + index - inL, postR - 1, map);
        return root;
    }
}
