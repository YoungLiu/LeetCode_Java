//Given a binary tree, find its minimum depth.
//
//        The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

package com.computinglife.leetcode.easy;

/**
 * Created by Young on 2015/10/3.
 */
public class MinimumDepthofBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if(root!=null&&root.left!=null&&root.right==null){
            return left+1;
        }
        if(root!=null&&root.left==null&&root.right!=null){
            return right+1;
        }
        return Math.min(left,right)+1;

    }
}
