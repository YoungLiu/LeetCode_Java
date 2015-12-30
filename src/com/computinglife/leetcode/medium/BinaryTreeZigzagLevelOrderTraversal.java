/*Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

        For example:
        Given binary tree {3,9,20,#,#,15,7},
         3
        / \
       9  20
         /  \
        15   7
        return its zigzag level order traversal as:
        [
            [3],
            [20,9],
            [15,7]
        ]*/

package com.computinglife.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by youngliu on 12/30/15.
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<TreeNode> tmp = new ArrayList<>();
        Queue<TreeNode> BFSqueeu = new LinkedList<>();
        boolean flag = true;
        tmp.add(root);
        while (tmp.size() != 0) {
            List<Integer> item = new ArrayList<>();
            if (flag) {
                //正序
                for (TreeNode tmpNode : tmp) {
                    item.add(tmpNode.val);
                }
                flag = false;
            } else {
                //倒序
                for (int i = tmp.size() - 1; i >= 0; i--) {
                    item.add(tmp.get(i).val);
                }
                flag = true;
            }
            res.add(item);
            //重新填充tmp，广度优先，使用队列
            for (TreeNode node : tmp) {
                if (node.left != null)
                    BFSqueeu.offer(node.left);
                if (node.right != null)
                    BFSqueeu.offer(node.right);
            }
            tmp.clear();
            while (BFSqueeu.size() != 0) {
                tmp.add(BFSqueeu.poll());
            }
            BFSqueeu.clear();
        }
        return res;
    }

}
