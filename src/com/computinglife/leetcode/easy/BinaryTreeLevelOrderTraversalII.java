//Given a binary tree, return the bottom-up level order traversal of its nodes' values.
//        (ie, from left to right, level by level from leaf to root).
//
//        For example:
//        Given binary tree {3,9,20,#,#,15,7},
//          3
//         / \
//        9  20
//          /  \
//         15   7
//        return its bottom-up level order traversal as:
//        [
//        [15,7],
//        [9,20],
//        [3]
//        ]

package com.computinglife.leetcode.easy;

import java.util.*;

/**
 * Created by Young on 2015/10/4.
 */
public class BinaryTreeLevelOrderTraversalII {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Stack<List<Integer>> tmpStack = new Stack<>();

        Queue<TreeNode> tmpQueue = new LinkedList<>();
        tmpQueue.add(root);

        while (tmpQueue.size() != 0) {
            int length = tmpQueue.size();
            List<Integer> tmp = new ArrayList<>();
            while (length != 0) {
                TreeNode topNode = tmpQueue.poll();
                if (topNode.right != null) {
                    tmpQueue.add(topNode.right);
                }
                if (topNode.left != null) {
                    tmpQueue.add(topNode.left);
                }
                tmp.add(topNode.val);
                length--;
            }
            tmpStack.push(tmp);
        }

        while (!tmpStack.empty()) {
            ret.add(tmpStack.pop());
        }

        return ret;
    }
}
