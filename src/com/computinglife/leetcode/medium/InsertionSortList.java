/*Sort a linked list using insertion sort.*/

package com.computinglife.leetcode.medium;

/**
 * Created by youngliu on 1/28/16.
 */
public class InsertionSortList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = new ListNode(head.val);
        ListNode pointer = head.next;

        while (pointer != null) {
            ListNode innerPointer = newHead;
            ListNode next = pointer.next;

            if (pointer.val <= newHead.val) {
                ListNode oldHead = newHead;
                newHead = pointer;
                newHead.next = oldHead;
            } else {
                while (innerPointer.next != null) {
                    if (pointer.val > innerPointer.val && pointer.val <= innerPointer.next.val) {
                        //exchange
                        ListNode oldNext = innerPointer.next;
                        innerPointer.next = pointer;
                        pointer.next = oldNext;
                    }
                    innerPointer = innerPointer.next;
                }
                if (innerPointer.next == null && pointer.val >= innerPointer.val) {
                    innerPointer.next = pointer;
                    pointer.next = null;
                }
            }
            pointer = next;
        }

        return newHead;
    }
}
