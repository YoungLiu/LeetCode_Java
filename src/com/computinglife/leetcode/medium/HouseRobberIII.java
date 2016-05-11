/*The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

        Determine the maximum amount of money the thief can rob tonight without alerting the police.

        Example 1:
            3
           / \
          2   3
           \   \
            3   1
        Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
        Example 2:
             3
            / \
           4   5
          / \   \
         1   3   1
        Maximum amount of money the thief can rob = 4 + 5 = 9.*/

package com.computinglife.leetcode.medium;

/**
 * Created by YanceyLiu on 5/1/2016.
 */
public class HouseRobberIII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int rob(TreeNode root) {
        return dfs(root)[0];
    }

    public int[] dfs(TreeNode root) {
        int[] dp = {0, 0};
        if (root != null) {
            int[] dpL = dfs(root.left);
            int[] dpR = dfs(root.right);
            dp[1] = dpL[0] + dpR[0];
            dp[0] = Math.max(dp[1], dpL[1] + dpR[1] + root.val);
        }
        return dp;
    }
}
