//Merge two sorted linked lists and return it as a new list. 
//		The new list should be made by splicing together the nodes of the first two lists.

//此题最好的解法是原地交叉插入，空间复杂度为常数。

package com.computinglife.leetcode.easy;

public class MergeTwoSortedLists {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode list = new ListNode(0);
		ListNode head = list;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				list.next = new ListNode(l1.val);
				l1 = l1.next;
			} else {
				list.next = new ListNode(l2.val);
				l2 = l2.next;
			}
			list = list.next;
		}
		list.next = (l1 == null) ? l2 : l1;
		return head.next;
	}

	public ListNode generate1() {
		ListNode node1 = new ListNode(-2);
		ListNode node2 = new ListNode(5);
		node1.next = node2;
		return node1;
	}

	public ListNode generate2() {
		ListNode node6 = new ListNode(6);
		ListNode node5 = new ListNode(1);
		node5.next = node6;
		ListNode node4 = new ListNode(-1);
		node4.next = node5;
		ListNode node3 = new ListNode(-3);
		node3.next = node4;
		ListNode node2 = new ListNode(-6);
		node2.next = node3;
		ListNode node1 = new ListNode(-9);
		node1.next = node2;
		return node5;
	}

	public static void main(String[] args) {
		MergeTwoSortedLists test = new MergeTwoSortedLists();
		ListNode l1 = test.generate1();
		ListNode l2 = test.generate2();
		test.mergeTwoLists(l1, l2);
	}

}
