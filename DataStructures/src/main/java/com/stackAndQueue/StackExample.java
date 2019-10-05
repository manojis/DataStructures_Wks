package com.stackAndQueue;

import java.util.*;

/**
 * poll() : Retrieves and removes the head of the queue represented by this deque (in other words, the first element of this deque), or returns null if this deque is empty.
 * remove() : Return the head of this list, throws NoSuchElementException if this list is empty
 * pollFirst() is the same as poll().
 * pollLast() return the last element of this list, or null if this list is empty
 * removeFirst() is the same as remove()
 * */
public class StackExample{

    // Check the difference between poll(), pollfirst() and polllast()
    public static void main(String[] args) {

        // create a LinkedList
        LinkedList list = new LinkedList();

        // add some elements
        list.add("Hello");
        list.add(2);
        list.add("Chocolate");
        list.add("10");

        // print the list
        System.out.println("LinkedList:" + list);

        System.out.println("first element of the list is : " + list.getFirst());
        System.out.println("last element of the list is : " + list.getLast());
        // using poll() to retrieve and remove the head
        // removes and displays "Geeks"
        System.out.println("Head element of the list is : " + list.poll());

        // retrieve and remove the last element of the list
        System.out.println("Last element of the list:" + list.pollLast());

        // print the list
        System.out.println("LinkedList:" + list);
    }
}