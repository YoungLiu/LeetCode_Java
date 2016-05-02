/*Given a non-empty array of integers, return the k most frequent elements.

        For example,
        Given [1,1,1,2,2,3] and k = 2, return [1,2].

        Note:
        You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
        Your algorithm's time complexity must be better than O(n log n), where n is the array's size.*/

package com.computinglife.leetcode.medium;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.*;
import java.util.List;

/**
 * Created by YanceyLiu on 5/2/2016.
 */
public class TopKFrequentElements {

    class Item {
        int val;
        int count;

        public Item(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();
        for (int tmp : nums) {
            if (count.containsKey(tmp)) {
                count.put(tmp, count.get(tmp) + 1);
            } else {
                count.put(tmp, 1);
            }
        }
        Comparator<Item> cmp = new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o2.count - o1.count;
            }
        };
        Queue<Item> q = new PriorityQueue<Item>(nums.length, cmp);
        for (Integer tmp : count.keySet()) {
            Item tmpItem = new Item(tmp, count.get(tmp));
            q.add(tmpItem);
        }
        while (k > 0) {
            res.add(q.poll().val);
            k--;
        }
        return res;
    }

    public static void main(String[] args) {
        TopKFrequentElements test = new TopKFrequentElements();
        int[] nums = {1, 1, 1, 2, 2, 3};
        List<Integer> res = test.topKFrequent(nums, 2);
        for (Integer tmp : res) {
            System.out.println(tmp);
        }
    }
}
