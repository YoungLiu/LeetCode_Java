//Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
//
//        For example:
//        Given binary tree {3,9,20,#,#,15,7},
//          3
//         / \
//        9  20
//          /  \
//         15   7
//        return its level order traversal as:
//        [
//        [3],
//        [9,20],
//        [15,7]
//        ]

package com.computinglife.leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Young on 2015/10/5.
 */
public class BinaryTreeLevelOrderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();

        if (root == null) {
            return ret;
        }

        Queue<TreeNode> tmpQueue = new LinkedList<>();
        tmpQueue.add(root);

        while (tmpQueue.size() != 0) {
            int length = tmpQueue.size();
            List<Integer> tmp = new ArrayList<>();
            while (length != 0) {
                TreeNode node = tmpQueue.poll();
                if (node.left != null)
                    tmpQueue.add(node.left);
                if (node.right != null)
                    tmpQueue.add(node.right);
                tmp.add(node.val);
                length--;
            }
            ret.add(tmp);
        }
        return ret;
    }
}
