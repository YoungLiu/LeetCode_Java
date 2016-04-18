//Remove all elements from a linked list of integers that have value val.
//
//        Example
//        Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
//        Return: 1 --> 2 --> 3 --> 4 --> 5

package com.computinglife.leetcode.easy;

/**
 * Created by Young on 2015/9/18.
 */
public class RemoveLinkedListElements {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x, ListNode next) {
            this.val = x;
            this.next = next;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        while (head.val == val) {
            head = head.next;
            if (head == null) {
                return null;
            }
        }
        ListNode tmp = head;
        while (tmp.next != null) {
            if (tmp.next.val == val) {
                tmp.next = tmp.next.next;
            } else {
                tmp = tmp.next;
            }
        }
        return head;
    }



    public ListNode generate() {
//        ListNode test05 = new ListNode(5, null);
//        ListNode test04 = new ListNode(4, test05);
//        ListNode test03 = new ListNode(3, test04);
        ListNode test02 = new ListNode(1, null);
        ListNode test01 = new ListNode(1, test02);
        return test01;
    }

    public static void main(String[] args) {
        RemoveLinkedListElements test = new RemoveLinkedListElements();
        ListNode head = test.generate();
        head = test.removeElements(head, 1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
