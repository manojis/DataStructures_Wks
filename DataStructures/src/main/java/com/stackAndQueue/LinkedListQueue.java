package com.stackAndQueue;

import java.util.Iterator;
import java.util.Queue;

/**
 * Created by 212561694 on 6/8/2017.
 */
public class LinkedListQueue<String> {
    private Node head, tail; //begin and end nodes
    private int size; // number of Objects

    //nested class to define node
    private class Node {
        Object data;
        Node next;
    }

    //Zero argument constructor
    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    //Remove Object from the beginning of the list.
    public Object delete() {
        Object temp = head.data;
        head = head.next;
        if (isEmpty()) {
            tail = null;
        }
        size--;
        return temp;
    }

    //Add Object to the end of the list.
    public void insert(Object data) {
        Node oldRear = tail;
        tail = new Node();
        tail.data = data;
        tail.next = null;
        if (isEmpty()) {
            head = tail;
        } else {
            oldRear.next = tail;
        }
        size++;
    }

    public int size() {
        return size;
    }

    //Iterator for traversing queue items
    public Object iterator() {
        return new LinkedQueueIterator();
    }

    //inner class to implement iterator interface
    private class LinkedQueueIterator implements Iterator<Object> {
        private int i = size;
        private Node first = head; //the first node

        public boolean hasNext() {
            return (i > 0);
        }

        public Object next() {
            Object data = first.data;
            first = first.next;
            i--;
            return data;
        }

        public void remove() {
            // not needed
        }
    }
}
