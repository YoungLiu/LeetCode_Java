//Reverse a singly linked list.

package com.computinglife.leetcode.easy;

public class ReverseLinkedList {

	public class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x, ListNode next) {
			this.val = x;
			this.next = next;
		}
	}

	public ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head;
		}
		if (head.next.next == null) {
			ListNode tmp = head;
			head = head.next;
			head.next = tmp;
			return head;
		}
		ListNode pre = head;
		head = head.next;
		ListNode back = head.next;
		while (back != null) {
			head.next = pre;
			pre = head;
			head = back;
			back = back.next;
		}
		return head;
	}
	
	public void genarate(){
		
	}

	public static void main(String[] args) {
		ListNode test05 = new ListNode(5, null);
		ListNode test04 = new ListNode(4, test05);
		ListNode test03 = new ListNode(3, test04);
		ListNode test02 = new ListNode(2, test03);
		ListNode test01 = new ListNode(1, test02);
	}
}
