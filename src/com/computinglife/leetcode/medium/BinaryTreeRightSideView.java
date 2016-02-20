/*Given a binary tree, imagine yourself standing on the right side of it,
        return the values of the nodes you can see ordered from top to bottom.

        For example:
        Given the following binary tree,
              1            <---
            /   \
           2     3         <---
            \     \
             5     4       <---
        You should return [1, 3, 4].*/

package com.computinglife.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by youngliu on 2/20/16.
 */
public class BinaryTreeRightSideView {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(queue.size()!=0){
            int size = queue.size();
            for(int i =0;i<size;i++){
                TreeNode top = queue.poll();
                if(i == 0){
                    res.add(top.val);
                }
                if(top.right!=null){
                    queue.add(top.right);
                }
                if(top.left!=null){
                    queue.add(top.left);
                }
            }
        }
        return res;
    }
}
