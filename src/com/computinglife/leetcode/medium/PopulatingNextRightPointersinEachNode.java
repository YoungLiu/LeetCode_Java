/*Given a binary tree

        struct TreeLinkNode {
            TreeLinkNode *left;
            TreeLinkNode *right;
            TreeLinkNode *next;
        }
        Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

        Initially, all next pointers are set to NULL.

        Note:

        You may only use constant extra space.
        You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
        For example,
        Given the following perfect binary tree,
            1
           /  \
          2    3
         / \  / \
        4  5  6  7
        After calling your function, the tree should look like:
            1 -> NULL
           /  \
          2 -> 3 -> NULL
         / \  / \
        4->5->6->7 -> NULL*/

package com.computinglife.leetcode.medium;

/**
 * Created by youngliu on 1/5/16.
 */
public class PopulatingNextRightPointersinEachNode {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode lastHead = root;
        TreeLinkNode pre = null;
        TreeLinkNode curHead = null;
        TreeLinkNode lastCur;
        while (lastHead != null) {
            lastCur = lastHead;
            while (lastCur != null) {
                if (lastCur.left != null) {
                    if (curHead == null) {
                        curHead = lastCur.left;
                        pre = curHead;
                    } else {
                        pre.next = lastCur.left;
                        pre = pre.next;
                    }
                }
                if (lastCur.right != null) {
                    if (curHead == null) {
                        curHead = lastCur.right;
                        pre = curHead;
                    } else {
                        pre.next = lastCur.right;
                        pre = pre.next;
                    }
                }
                lastCur = lastCur.next;
            }
            lastHead = curHead;
            curHead = null;
        }
    }
}
