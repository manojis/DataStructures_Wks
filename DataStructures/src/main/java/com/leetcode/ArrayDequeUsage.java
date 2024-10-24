package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * add(Element e)	The method inserts a particular element at the end of the deque.
 * addFirst(Element e)	The method inserts particular element at the start of the deque.
 * addLast(Element e) 	The method inserts a particular element at the end of the deque. It is similar to the add() method
 * offer(Element e)	The method inserts element at the end of deque.
 * offerFirst(Element e) The method inserts element at the front of deque.
 * offerLast(Element e)	The method inserts element at the end of the deque.
 *
 * element() 	The method returns element at the head of the deque
 * getFirst()	The method returns first element of the deque
 * getLast()	The method returns last element of the deque
 * 
 * peek()	The method returns head element without removing it.
 * peekFirst() Retrieves, but does not remove, the first element of this deque, or returns null if this deque is empty.
 * peekLast() Retrieves, but does not remove, the last element of this deque, or returns null if this deque is empty.
 * 
 * poll()	The method returns head element and also removes it
 * pollFirst() Retrieves and removes the first element of this deque, or returns null if this deque is empty
 * pollLast() Retrieves and removes the last element of this deque, or returns null if this deque is empty
 * 
 * pop()	The method pops out an element for stack represented by deque
 * 
 * push(Element e)	The method pushes an element onto stack represented by deque
 * 
 * remove()	The method returns head element and also removes it
 * removeFirst()	The method returns the first element and also removes it
 * removeIf<(Predicate<? super Element> filter)	Removes all the elements of this collection that satisfy the given predicate.
 * 
 * clear() 	The method removes all deque elements.
 * clone()	The method copies the deque.
 * contains(Obj)	The method checks whether a deque contains the element or not
 *
 * isEmpty()	The method checks whether the deque is empty or not.
 * iterator()	Returns an iterator over the elements in this deque.
 *
 * size()	Returns the number of elements in this deque.
 * toArray()	Returns an array containing all the elements in this deque in proper sequence (from first to the last element).
 */
public class ArrayDequeUsage {
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("manoj");
        deque.addLast("arya");
        deque.addLast("manvi");
        deque.addLast("amma");
        deque.addLast("achan");
    }
}

