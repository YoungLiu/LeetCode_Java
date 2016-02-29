/*Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

        Note:
        You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

        Follow up:
        What if the BST is modified (insert/delete operations) often
        and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

        Hint:

        Try to utilize the property of a BST.
        What if you could modify the BST node's structure?
        The optimal runtime complexity is O(height of BST).*/

package com.computinglife.leetcode.medium;

import java.util.Stack;

/**
 * Created by YanceyLiu on 2/29/2016.
 */
public class KthSmallestElementinaBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //O(n)
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode point = root;
        int result = 0;
        while (!stack.isEmpty() || point != null) {
            if(point!=null){
                stack.push(point);
                point = point.left;
            }else{
                TreeNode t = stack.pop();
                k--;
                if (k == 0) {
                    result = t.val;
                }
                point = t.right;
            }
        }
        return result;
    }
}
