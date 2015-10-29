//Given a linked list, swap every two adjacent nodes and return its head.
//
//For example,
//Given 1->2->3->4, you should return the list as 2->1->4->3.
//
//Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
//
//Subscribe to see which companies asked this question

package com.computinglife.leetcode.medium;

public class SwapNodesinPairs {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode swapPairs(ListNode head) {
		if (head == null) {
			return head;
		}
		if (head.next == null) {
			return head;
		}
		ListNode front = head;
		ListNode end = head.next;
		ListNode link = head;// 链接点
		head = head.next;
		while (end != null) {
			front.next = end.next;
			end.next = front;
			if (front.next != null && front.next.next != null) {
				front = front.next;
				end = end.next.next.next;
				link.next = end;
				link = front;
			} else {
				break;
			}
		}
		return head;
	}
}
