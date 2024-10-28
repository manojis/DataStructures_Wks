package com.leetcode;

import java.util.*;

class LruCache {
    /** To remove the least used one, a queue has to be created. Newly added or accessed one goes to the front of the queue and least used to back of the queue
     * Need a doubly linked list for this
     * add the key value pair to both doubly linked list and the hashmap
     * Need to create a node with next and prev address
     **/
    private class ListNode {
        int key;
        int value;
        ListNode prev;
        ListNode next;
    }

    // Hashtable backs up the Doubly Linked List for O(1) access to cache items
    Map<Integer, ListNode> hashtable = new HashMap<Integer, ListNode>();

    // The head and psuedoTail are just psuedo head and psuedoTail
    ListNode psuedoHead;
    ListNode psuedoTail;

    int totalItemsInCache;
    int maxCapacity;

    /**
     * creating the constructor to set the capacity
     * while creating the LRUCache instance we need to set capacity and also create a head and tail and wire them together
     **/
    public LruCache(int maxCapacity) {

        // Cache starts empty and capacity is set by client
        totalItemsInCache = 0;
        this.maxCapacity = maxCapacity;

        /** Dummy psuedoHead and psuedoTail nodes to avoid empty states
         * We will have our head and tail attributes both set to dummy nodes.
         * The "real" head will be head.next and the "real" tail will be tail.prev.
         * These dummy nodes sit just "outside" of our linked list. What is the purpose? We never want head or tail to be null.
         */
        psuedoHead = new ListNode();
        psuedoTail = new ListNode();

        // Wire the psuedoHead and psuedoTail together
        psuedoHead.next = psuedoTail;
        psuedoTail.prev = psuedoHead;
  }

    public int get(int key) {
        // hashtable.getOrDefault(key, null);
        ListNode node = hashtable.get(key);

        if (node == null) {
          return -1; // we should throw an exception here, but for Leetcode's sake
        }
        // Item has been accessed. Move to the front of the cache
        moveToHead(node);

        return node.value;
    }

    /** when a key needs to be updated, it could be anywhere in the doubly linked list,
     * so we need to get the position of the node using the key from the hashmap and update it bring it to the front of the queue.
     * @param key
     * @param value
     */

    public void put(int key, int value) {
        ListNode node = hashtable.get(key);

        if (node == null) {
          // Item not found, create a new entry
            ListNode newNode = new ListNode();
            newNode.key = key;
            newNode.value = value;

            // Add to the hashtable and the actual list that represents the cache
            hashtable.put(key, newNode);
            addToFront(newNode);
            totalItemsInCache++;

            // If over capacity remove the LRU item
            if (totalItemsInCache > maxCapacity) {
                removeLRUEntry();
            }
        } else {
            // If item is found in the cache, just update it and move it to the psuedoHead of the list
            node.value = value;
            moveToHead(node);
        }
    }
    private void addToFront(ListNode node) {
        // Wire up the new node being to be inserted
        node.prev = psuedoHead;
        node.next = psuedoHead.next;
        /*
          Re-wire the node after the psuedoHead. Our node is still sitting "in the middle of nowhere".
          We got the new node pointing to the right things, but we need to fix up the original
          psuedoHead & psuedoHead's next.
          head <-> head.next <-> head.next.next <-> head.next.next.next <-> ...
          ^            ^
          |- new node -|
          That's where we are before these next 2 lines.
        */
        psuedoHead.next.prev = node;
        psuedoHead.next = node;
    }

    private void removeLRUEntry() {
        ListNode psuedoTail = popTail();
        hashtable.remove(psuedoTail.key);
        --totalItemsInCache;
    }

    private ListNode popTail() {
        ListNode tailItem = psuedoTail.prev;
        removeFromList(tailItem);
        return tailItem;
    }

    private void removeFromList(ListNode node) {
        ListNode savedPrev = node.prev;
        ListNode savedNext = node.next;

        savedPrev.next = savedNext;
        savedNext.prev = savedPrev;
    }

    private void moveToHead(ListNode node) {
        removeFromList(node);
        addToFront(node);
    }
    public static void main(String[] args){
        int capacity = 3;
        LruCache obj = new LruCache(capacity);
        int key = 1234;
        int value = 3243223;
        obj.put(key,value);

        key = 12334;
        value = 32243223;
        obj.put(key,value);

        key = 12434;
        value = 32543223;
        obj.put(key,value);
        int param_1 = obj.get(key);
        key = 12434;
        value = 32543223;
        obj.put(key,value);


        System.out.println(param_1);
    }
}
