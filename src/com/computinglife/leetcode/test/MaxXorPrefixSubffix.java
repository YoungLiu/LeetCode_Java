package com.computinglife.leetcode.test;

import java.util.Scanner;

/**
 * Created by YanceyLiu on 5/21/2016.
 */
public class MaxXorPrefixSubffix {

    public static TrieTree root;
    public static final int N = 100005;
    public static final long INF = 1 << 61;
    public static long[] array = new long[N];

    static class TrieTree {
        public TrieTree[] next;

        public TrieTree() {
            this.next = new TrieTree[2];
        }
    }

    public static void insert(long n) {
        TrieTree p = root;
        for (int i = 63; i >= 0; i--) {
            int id = (int) (n >> i) & 1;
            if (p.next[id] == null) {
                p.next[id] = new TrieTree();
            }
            p = p.next[id];
        }
    }

    public static void delete(TrieTree t) {
        if (t == null) {
            return;
        }
        for (int i = 0; i < 2; i++) {
            if (t.next[i] != null) {
                delete(t.next[i]);
            }
        }
    }

    public static long match(long n) {
        n = ~n;
        long res = 0;
        TrieTree p = root;
        for (int i = 63; i >= 0; i--) {
            res <<= 1;
            int curBit = (int) (n >> i) & 1;
            if (curBit == 1) {
                if (p.next[1] != null) {
                    p = p.next[1];
                    res++;
                } else {
                    p = p.next[0];
                }
            } else {
                if (p.next[0] != null) {
                    p = p.next[0];
                    res++;
                } else {
                    p = p.next[1];
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        root = new TrieTree();
        long tmp = 0;
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
            tmp ^= array[i];
            insert(array[i]);
        }
        tmp = 0;
        long res = -INF;
        for (int i = 0; i < n; i++) {
            tmp ^= array[n - i - 1];
            res = Math.max(res, match(tmp));
        }
        System.out.println(res);
        delete(root);

        return;
    }
}
