/*Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

        For example,
        Given n = 3, your program should return all 5 unique BST's shown below.

        1         3     3      2      1
         \       /     /      / \      \
          3     2     1      1   3      2
         /     /       \                 \
        2     1         2                 3*/

package com.computinglife.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youngliu on 12/27/15.
 */
public class UniqueBinarySearchTreesII {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<TreeNode>();
        }
        return generate(1, n);
    }

    public List<TreeNode> generate(int left, int right) {
        List<TreeNode> res = new ArrayList<>();
        if (left > right) {
            res.add(null);
            return res;
        }
        for (int i = left; i <= right; i++) {
            List<TreeNode> leftTree = generate(left, i - 1);
            List<TreeNode> rightTree = generate(i + 1, right);
            for (TreeNode l : leftTree) {
                for (TreeNode r : rightTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
