/*Sort a linked list in O(n log n) time using constant space complexity.*/

package com.computinglife.leetcode.medium;

/**
 * Created by youngliu on 1/29/16.
 */
public class SortList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode head2 = slow.next;
        ListNode head1 = head;
        slow.next = null;
        head1 = mergeSort(head1);
        head2 = mergeSort(head2);
        return merge(head1, head2);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode helper = new ListNode(-1);
        helper.next = head1;
        ListNode pre = helper;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                head1 = head1.next;
            } else {
                ListNode next = head2.next;
                head2.next = pre.next;
                pre.next = head2;
                head2 = next;
            }
            pre = pre.next;
        }
        if (head2 != null) {
            pre.next = head2;
        }
        return helper.next;
    }

}
