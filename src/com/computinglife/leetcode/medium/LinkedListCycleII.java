/*Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

        Note: Do not modify the linked list.

        Follow up:
        Can you solve it without using extra space?*/

package com.computinglife.leetcode.medium;

/**
 * Created by youngliu on 1/25/16.
 */
public class LinkedListCycleII {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        boolean flag = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            return null;
        }
        while (head != fast) {
            head = head.next;
            fast = fast.next;
        }
        return head;
    }
}
