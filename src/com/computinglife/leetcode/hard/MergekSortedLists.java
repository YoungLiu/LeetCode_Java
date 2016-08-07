package com.computinglife.leetcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by yliu on 8/7/16.
 */
public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val > o2.val) {
                    return 1;
                } else if (o1.val < o2.val) {
                    return -1;
                }
                return 0;
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;
        for (ListNode tmp : lists) {
            if (tmp != null)
                queue.add(tmp);
        }
        while (queue.size() != 0) {
            ListNode tmp = queue.poll();
            pointer.next = tmp;
            pointer = pointer.next;
            if (pointer.next != null) {
                queue.add(pointer.next);
            }
        }
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
