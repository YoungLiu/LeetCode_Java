/*Given a singly linked list where elements are sorted in ascending order,
        convert it to a height balanced BST.
        此题不好理解，目前还没有弄懂。2016/1/2
        */

package com.computinglife.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youngliu on 1/1/16.
 */
public class ConvertSortedListtoBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode current = head;
        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }
        List<ListNode> list = new ArrayList<>();
        list.add(head);
        return helper(list, 0, length - 1);
    }

    private TreeNode helper(List<ListNode> list, int start, int end) {
        if (start > end) {
            return null;
        }
        int m = (start + end) / 2;
        TreeNode left = helper(list, start, m - 1);
        TreeNode root = new TreeNode(list.get(0).val);
        root.left = left;
        list.set(0, list.get(0).next);
        root.right = helper(list, m + 1, end);
        return root;
    }

}
