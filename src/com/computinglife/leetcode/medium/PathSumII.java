/*Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

        For example:
        Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
        return
        [
            [5,4,11,2],
            [5,8,4,5]
        ]*/

package com.computinglife.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youngliu on 1/4/16.
 */
public class PathSumII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(root, sum, res, new ArrayList<Integer>());
        return res;
    }

    private void helper(TreeNode node, int sum, List<List<Integer>> res, List<Integer> item) {
        item.add(node.val);
        sum -= node.val;
        if (sum == 0 && node.left == null && node.right == null) {
            res.add(new ArrayList<>(item));
            return;
        }
        if (node.left != null) {
            helper(node.left, sum, res, item);
            item.remove(item.size() - 1);
        }
        if (node.right != null) {
            helper(node.right, sum, res, item);
            item.remove(item.size() - 1);
        }

    }

}
