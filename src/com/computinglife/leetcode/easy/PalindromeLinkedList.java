//Given a singly linked list, determine if it is a palindrome.
//
//Follow up:
//Could you do it in O(n) time and O(1) space?
//此题关键在于在空间复杂度为1的限制下完成字符串翻转,涉及找出字符串中点和原地翻转两个关键点

package com.computinglife.leetcode.easy;


public class PalindromeLinkedList {

	public class ListNode {
		public int val;
		public ListNode next;

		public ListNode(int x, ListNode next) {
			this.val = x;
			this.next = next;
		}

	}

	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		// 此中点取后半段
		ListNode mid = getMiddle(head);
		ListNode right = reverseList(mid);
		while (right != null && head != null) {
			if (head.val != right.val) {
				return false;
			}
			head = head.next;
			right = right.next;
		}
		return true;

	}

	// 获得字符串中点
	public ListNode getMiddle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		do {
			fast = fast.next;
			if (fast != null) {
				fast = fast.next;
				slow = slow.next;
			}
		} while (fast != null);
		return slow;
	}

	// 字符串原地翻转
	public ListNode reverseList(ListNode mid) {
		// 此mid为后半段
		if (mid.next == null) {
			return mid;
		}
		ListNode temp = mid.next;
		ListNode head = temp;
		mid.next = null;
		while (temp.next != null) {
			head = temp.next;
			temp.next = mid;
			mid = temp;
			temp = head;
		}
		head.next = mid;
		return head;
	}

	public ListNode generateTest() {
		// ListNode test5 = new ListNode(2, null);
		// ListNode test4 = new ListNode(1, test5);
		// ListNode test3 = new ListNode(1, null);
		ListNode test2 = new ListNode(1, null);
		ListNode test1 = new ListNode(0, test2);
		ListNode test0 = new ListNode(1, test1);
		return test0;
	}

	public static void main(String[] args) {
		PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
		ListNode test = palindromeLinkedList.generateTest();
		System.out.println(palindromeLinkedList.isPalindrome(test));
	}

}
