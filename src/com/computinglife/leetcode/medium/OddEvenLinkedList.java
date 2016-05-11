/*Given a singly linked list, group all odd nodes together followed by the even nodes.
        Please note here we are talking about the node number and not the value in the nodes.

        You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

        Example:
        Given 1->2->3->4->5->NULL,
        return 1->3->5->2->4->NULL.

        Note:
        The relative order inside both the even and odd groups should remain as it was in the input.
        The first node is considered odd, the second node even and so on ...*/

package com.computinglife.leetcode.medium;

/**
 * Created by YanceyLiu on 5/3/2016.
 */
public class OddEvenLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        boolean oddFlag = true, evenFlag = true;
        while (oddFlag || evenFlag) {
            if (odd.next != null && odd.next.next != null) {
                odd.next = odd.next.next;
                odd = odd.next;
            }else{
                oddFlag = false;
            }

            if (even.next != null && even.next.next != null) {
                even.next = even.next.next;
                even = even.next;
            }else{
                evenFlag = false;
            }
        }

        odd.next = evenHead;
        even.next = null;
        return head;
    }
}
