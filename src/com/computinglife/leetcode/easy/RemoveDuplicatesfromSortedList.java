//Given a sorted linked list, delete all duplicates such that each element appear only once.
//
//        For example,
//        Given 1->1->2, return 1->2.
//        Given 1->1->2->3->3, return 1->2->3.

package com.computinglife.leetcode.easy;

/**
 * Created by Young on 2015/10/6.
 */
public class RemoveDuplicatesfromSortedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode tmp = head;
        while (tmp.next != null) {
            if (tmp.val == tmp.next.val && tmp.next.next != null) {
                tmp.next = tmp.next.next;
                continue;
            }
            if (tmp.val == tmp.next.val && tmp.next.next == null) {
                tmp.next = null;
                break;
            }
            tmp = tmp.next;
        }
        return head;
    }


}
