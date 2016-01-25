/*Given a linked list, determine if it has a cycle in it.

        Follow up:
        Can you solve it without using extra space?*/

package com.computinglife.leetcode.medium;

/**
 * Created by youngliu on 1/25/16.
 */
public class LinkedListCycle {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            } else {
                return false;
            }
            if (fast.equals(slow)) {
                return true;
            }
        }
        return false;
    }
}
