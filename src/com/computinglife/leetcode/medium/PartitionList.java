/*Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

        You should preserve the original relative order of the nodes in each of the two partitions.

        For example,
        Given 1->4->3->2->5->2 and x = 3,
        return 1->2->2->4->3->5.*/

package com.computinglife.leetcode.medium;

/**
 * Created by youngliu on 12/23/15.
 */
public class PartitionList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);

        ListNode lefthead = left;
        ListNode righthead = right;

        while (head != null) {
            if (head.val < x) {
                left.next = head;
                head = head.next;
                left = left.next;
                left.next = null;
            } else {
                right.next = head;
                head = head.next;
                right = right.next;
                right.next = null;
            }
        }

        //拼接
        left.next = righthead.next;
        return lefthead.next;
    }

    public ListNode generate() {
        int[] nums = new int[]{1, 4, 3, 2, 5, 2};
        ListNode head = new ListNode(nums[0]);
        ListNode point = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode tmp = new ListNode(nums[i]);
            point.next = tmp;
            point = point.next;
        }
        return head;
    }

    public static void main(String[] args) {
        PartitionList test = new PartitionList();
        ListNode head = test.generate();
        ListNode res = test.partition(head,3);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
