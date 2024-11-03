package com.leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/lru-cache/solution/

public class LruCache_LeetCode {
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
    }

    // Common method we need for both PUT and GET
    private void moveToHead(DLinkedNode node){
        /**
         * Move certain node in between to the head.
         */
        removeNode(node);
        addNode(node);
    }

    private void removeNode(DLinkedNode node){
        /**
         * Remove an existing node from the linked list.
         * and connect the prev and next
         */
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }
    // if new node call this method directly, else call moveToHead method
    private void addNode(DLinkedNode node) {
        /**
         * Always add the new node right after head.
         */
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) return -1;

        // move the accessed node to the head;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if(node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            // push it to hashmap
            cache.put(key, newNode);
            // push it to linked list of nodes
            addNode(newNode);
            ++size;
            if(size > capacity) {
                // pop the tail and also remove from the cache
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            // update the value since it would be a change
            node.value = value;
            moveToHead(node);
        }
    }

    private DLinkedNode popTail() {
        /**
         * Pop the current tail.
         */
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    public LruCache_LeetCode(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        // head.prev = null;
        tail = new DLinkedNode();
        // tail.next = null;
        head.next = tail;
        tail.prev = head;
    }
}
