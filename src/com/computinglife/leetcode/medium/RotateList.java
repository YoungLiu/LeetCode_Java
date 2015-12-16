//Given a list, rotate the list to the right by k places, where k is non-negative.
//
//For example:
//Given 1->2->3->4->5->NULL and k = 2,
//return 4->5->1->2->3->NULL.

package com.computinglife.leetcode.medium;

public class RotateList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return head;
        }
        int length = 1;
        ListNode tmp = head;
        while (tmp.next != null) {
            length++;
            tmp = tmp.next;
        }
        //处理k的值大于链表长度的情况
        k %= length;
        if (k == 0) {
            return head;
        }

        ListNode first = head;
        ListNode second = head;
        while (first.next != null) {
            if (k > 0) {
                first = first.next;
                k--;
            } else {
                first = first.next;
                second = second.next;
            }
        }
        //各指针完成站位
        first.next = head;
        head = second.next;
        second.next = null;
        return head;
    }
}
