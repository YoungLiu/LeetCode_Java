//You are given two linked lists representing two non-negative numbers. 
//The digits are stored in reverse order and each of their nodes contain a single digit. 
//Add the two numbers and return it as a linked list.
//
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8

package com.computinglife.leetcode.medium;

public class AddTwoNumbers {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return l1 == null ? l2 : l1;
		}
		int current = 0;
		int carry = 0;
		ListNode head = null;
		ListNode point = null;
		while (l1 != null || l2 != null) {
			if (l1 != null && l2 != null) {
				if (carry == 0) {
					current = l1.val + l2.val;
				} else {
					current = l1.val + l2.val + carry;
				}
				ListNode tmp = new ListNode(current % 10);
				if (head == null) {
					head = tmp;
					point = tmp;
				} else {
					point.next = tmp;
					point = tmp;
				}
				carry = current / 10;
				l1 = l1.next;
				l2 = l2.next;
			} else {
				if (carry == 0) {
					point.next = l1 == null ? l2 : l1;
					break;
				} else {
					current = (l1 == null ? l2.val : l1.val) + carry;
					ListNode tmp = new ListNode(current % 10);
					point.next = tmp;
					point = tmp;
					carry = current / 10;
					if (l1 == null) {
						l2 = l2.next;
					} else {
						l1 = l1.next;
					}
				}
			}
		}
		if (carry != 0) {
			ListNode tmp = new ListNode(carry);
			point.next = tmp;
			tmp.next = null;
		}

		return head;
	}

	public static void main(String[] args) {
		AddTwoNumbers test = new AddTwoNumbers();

		ListNode l1 = test.new ListNode(5);
		ListNode l2 = test.new ListNode(5);

		test.addTwoNumbers(l1, l2);
	}
}
