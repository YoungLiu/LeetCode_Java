/*Write a program to find the nth super ugly number.

        Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.
        For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32]
        is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.

        Note:
        (1) 1 is a super ugly number for any given primes.
        (2) The given numbers in primes are in ascending order.
        (3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.

        2 7 13 19    ----> 12

        1
        */

package com.computinglife.leetcode.medium;

import java.util.PriorityQueue;

/**
 * Created by YanceyLiu on 5/6/2016.
 */
public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (primes == null || primes.length == 0 || n < 0) {
            return -1;
        }
        PriorityQueue<Item> queue = new PriorityQueue<>();
        for (int i = 0; i < primes.length; i++) {
            Item tmp = new Item(0, primes[i], primes[i]);
            queue.add(tmp);
        }
        int[] ugly = new int[n];
        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            Item top = queue.peek();
            ugly[i] = top.val;
            do {
                Item cur = queue.poll();
                cur.val = ugly[++cur.index] * cur.prime;
                queue.add(cur);
            } while (!queue.isEmpty() && ugly[i] == queue.peek().val);
        }
        return ugly[n - 1];

    }

    public class Item implements Comparable {
        private Integer index;
        private Integer val;
        private Integer prime;

        public Item(Integer index, Integer val, Integer prime) {
            this.index = index;
            this.val = val;
            this.prime = prime;
        }

        @Override
        public int compareTo(Object o) {
            Item o1 = (Item) o;
            return this.val - o1.val;
        }
    }

    public static void main(String[] args) {
        SuperUglyNumber test = new SuperUglyNumber();
        int[] primes = {2, 7, 13, 19};
        System.out.println(test.nthSuperUglyNumber(12, primes));
    }
}
