/*Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

        For example,
        Given 1->2->3->3->4->4->5, return 1->2->5.
        Given 1->1->1->2->3, return 2->3.*/

package com.computinglife.leetcode.medium;

/**
 * Created by youngliu on 12/23/15.
 */
public class RemoveDuplicatesfromSortedListII {
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
        boolean flag = false;
        //处理头部相等问题
        ListNode pre = new ListNode(Integer.MAX_VALUE);
        pre.next = head;
        ListNode point = pre;
        while (point.next != null) {
            ListNode tmp = point.next;
            flag = false;
            while (tmp.next != null && tmp.val == tmp.next.val) {
                tmp = tmp.next;
                flag = true;
            }
            if (flag) {
                point.next = tmp.next;
            } else {
                point = tmp;
            }
        }
        return pre.next;
    }
}
