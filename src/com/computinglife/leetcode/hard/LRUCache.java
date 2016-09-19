package com.computinglife.leetcode.hard;

import java.util.HashMap;

/**
 * Created by yliu on 9/19/16.
 */
public class LRUCache {

    class DlinkedNode {
        public int key;
        public int value;
        public DlinkedNode pre;
        public DlinkedNode post;
    }

    private HashMap<Integer, DlinkedNode> cache = new HashMap<>();
    private int count;
    private int capacity;
    private DlinkedNode head, tail;

    // always add the node to the right of the head
    private void addNode(DlinkedNode node) {
        node.post = head.post;
        node.pre = head;

        head.post.pre = node;
        head.post = node;
    }

    // remove the node from the Dlinked list
    private void removeNode(DlinkedNode node) {
        node.pre.post = node.post;
        node.post.pre = node.pre;
    }

    private void moveToHead(DlinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
        return;
    }

    private DlinkedNode popTail() {
        DlinkedNode node = this.tail.pre;
        this.removeNode(node);
        return node;
    }

    public LRUCache(int capacity){
        this.capacity = capacity;
        this.head = new DlinkedNode();
        this.tail = new DlinkedNode();
        this.head.pre = null;
        this.head.post = tail;
        this.tail.pre = head;
        this.tail.post = null;
        this.count = 0;
    }

    public int get(int key) {
        DlinkedNode node = cache.get(key);
        if(node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void set(int key, int value) {
        DlinkedNode node = cache.get(key);
        if(node == null) {
            node = new DlinkedNode();
            node.key = key;
            node.value = value;
            this.cache.put(key, node);
            this.addNode(node);
            this.count++;

            if(this.count > this.capacity) {
                DlinkedNode tmp = popTail();
                this.cache.remove(tmp.key);
                this.count--;
            }
        }else {
            node.value = value;
            this.moveToHead(node);
        }
    }
}
