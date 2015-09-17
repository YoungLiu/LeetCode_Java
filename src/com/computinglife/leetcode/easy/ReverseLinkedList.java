//Reverse a singly linked list.

package com.computinglife.leetcode.easy;

public class ReverseLinkedList {

    public class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x, ListNode next) {
            this.val = x;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            ListNode tmp = head;
            head = head.next;
            head.next = tmp;
            tmp.next = null;
            return head;
        }
        ListNode tmp = head.next;
        ListNode behind = tmp;
        head.next = null;
        while (tmp.next != null) {
            behind = tmp.next;
            tmp.next = head;
            head = tmp;
            tmp = behind;
        }
        behind.next = head;
        return behind;
    }

    public ListNode generate() {
        ListNode test05 = new ListNode(5, null);
        ListNode test04 = new ListNode(4, test05);
        ListNode test03 = new ListNode(3, test04);
        ListNode test02 = new ListNode(2, test03);
        ListNode test01 = new ListNode(1, test02);
        return test01;
    }

    public static void main(String[] args) {
        ReverseLinkedList test = new ReverseLinkedList();
        ListNode head = test.generate();
        head = test.reverseList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}