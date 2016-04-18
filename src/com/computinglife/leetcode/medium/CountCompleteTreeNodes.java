/*Given a complete binary tree, count the number of nodes.

        Definition of a complete binary tree from Wikipedia:
        In a complete binary tree every level, except possibly the last, is completely filled,
        and all nodes in the last level are as far left as possible.
        It can have between 1 and 2h nodes inclusive at the last level h.*/

package com.computinglife.leetcode.medium;

import java.util.LinkedList;

/**
 * Created by youngliu on 2/26/16.
 */
public class CountCompleteTreeNodes {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //Time Limit Exceeded!!!
    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode item = queue.poll();
            count++;
            if (item.left != null) {
                queue.add(item.left);
            }
            if (item.right != null) {
                queue.add(item.right);
            }
        }
        return count;
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int hight = 1;
        int leftHight = getLeftHight(root.left);
        int rightHight = getRightHight(root.right);

        if (leftHight == rightHight) {
            hight += leftHight;
            return (2 << (hight - 1)) - 1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }

    private int getLeftHight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int hight = 1;
        while (root.left != null) {
            hight++;
            root = root.left;
        }
        return hight;
    }

    private int getRightHight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int hight = 1;
        while (root.right != null) {
            hight++;
            root = root.right;
        }
        return hight;
    }
}
