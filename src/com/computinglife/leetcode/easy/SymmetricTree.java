//Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
//
//        For example, this binary tree is symmetric:
//
//            1
//           / \
//          2   2
//         / \ / \
//        3  4 4  3
//        But the following is not:
//            1
//           / \
//          2   2
//           \   \
//            3   3

package com.computinglife.leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Young on 2015/10/5.
 */
public class SymmetricTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

//    private List<Integer> tmp = new ArrayList<>();
//
//    public boolean isSymmetric(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        midOrder(root);
//        for (int i = 0, j = tmp.size() - 1; i < j; i++, j--) {
//            if (!tmp.get(i).equals(tmp.get(j))) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public void midOrder(TreeNode node) {
//        if (node == null) {
//            tmp.add(-1);
//            return;
//        }
//
//        if(node.left == null && node.right == null){
//            tmp.add(node.val);
//            return;
//        }
//
//        midOrder(node.left);
//        tmp.add(node.val);
//        midOrder(node.right);
//    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<Integer> tmp = new ArrayList<>();
        Queue<TreeNode> tmpQueue = new LinkedList<>();
        tmpQueue.add(root);
        tmpQueue.add(null);
        while (tmpQueue.size() != 0) {
            TreeNode node = tmpQueue.poll();
            if (node == null) {
                if (tmpQueue.size() != 0) {
                    //System.out.println(tmp.toString());
                    int i = 0;
                    int j = tmp.size() - 1;
                    while (i < j) {
                        if (!tmp.get(i++).equals(tmp.get(j--))) {
                            return false;
                        }
                    }
                    tmpQueue.add(null);
                    tmp.removeAll(tmp);
                }
            } else {
                if (node.left != null) {
                    tmpQueue.add(node.left);
                    tmp.add(node.left.val);
                } else {
                    tmp.add(Integer.MAX_VALUE);
                }
                if (node.right != null) {
                    tmpQueue.add(node.right);
                    tmp.add(node.right.val);
                } else {
                    tmp.add(Integer.MAX_VALUE);
                }
            }
        }
        return true;
    }

    public TreeNode generateTest() {
        TreeNode node5 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        node3.left = node5;
        TreeNode node4 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        node2.left = node4;
        TreeNode node1 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        return node1;
    }

    public static void main(String[] args) {
        SymmetricTree test = new SymmetricTree();
        TreeNode root = test.generateTest();
        System.out.println(test.isSymmetric(root));
    }
}
