package com.computinglife.leetcode.hard;

/**
 * Created by yliu on 8/7/16.
 */
public class ReverseNodesinKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return null;
        }
        ListNode curr = head;
        int count = 0;
        while(curr != null && count<k){
            count++;
            curr = curr.next;
        }
        if(count == k){
            curr = reverseKGroup(curr, k);

            while(count-- != 0){
                ListNode tmp = head.next;
                head.next = curr;
                curr = head;
                head = tmp;
            }
            head = curr;
        }
        return head;
    }
}
