//Given a linked list, remove the nth node from the end of list and return its head.
//
//For example,
//
//   Given linked list: 1->2->3->4->5, and n = 2.
//
//   After removing the second node from the end, the linked list becomes 1->2->3->5.
//Note:
//Given n will always be valid.
//Try to do this in one pass.

package com.computinglife.leetcode.easy;

public class RemoveNthNodeFromEndofList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (n == 0) {
			return head;
		}
		ListNode first = head;
		ListNode pointFront = head;
		ListNode pointBehind = head;
		while (pointFront != null) {
			pointFront = pointFront.next;
			if (n >= 0) {
				n--;
			} else {
				pointBehind = pointBehind.next;
			}
		}
		if (n >= 0) {
			return first.next;
		}
		if (pointBehind.next == null) {
			return null;
		}
		if (pointBehind.next.next == null) {
			pointBehind.next = null;
		} else {
			pointBehind.next = pointBehind.next.next;
		}
		return first;
	}

}
