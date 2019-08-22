
package com.linkedList;

import java.util.*;

public class LinkedList {	
	
	//A linked list object holds a reference to the first node, and each node holds a reference to the next node
	//Here variable "first" is the linked list object.
    private Node first;

    class Node
    {
        public Object data;
        public Node next;
    }

    /**
     Constructs an empty linked list.
     */
    public LinkedList()
    {

        first = null;
    }

    /**
     Returns the first element in the linked list.
     @return the first element in the linked list
     */
    public Object getFirst()
    {
        if (first == null)
            throw new NoSuchElementException();
        return first.data;
    }

    /**
     Removes the first element in the linked list.
     @return the removed element
     */
    public Object removeFirst()
    {
        if (first == null)
            throw new NoSuchElementException();
        Object element = first.data;
        first = first.next;
        return element;
    }

    /**
     Adds an element to the front of the linked list.
     @param element the element to add
     */
    public Node addFirst(Object element)
    {
        Node newNode = new Node();
        newNode.data = element;
        newNode.next = first;
        first = newNode;
        return first;
    }
    
    /**
     Returns an iterator for iterating through this list.
     @return an iterator for iterating through this list
     */
    public ListIterator listIterator()
    {
        return new LinkedListIterator();
    }

    class LinkedListIterator implements ListIterator
    {
        private Node current;
        private Node previous;

        /**
         Constructs an iterator that points to the front
         of the linked list.
         */
        public LinkedListIterator()
        {
            current = null;
            previous = null;
        }

        /**
         Tests if there is an element after the iterator current.
         @return true if there is an element after the iterator current
         */
        public boolean hasNext()
        {
            if (current == null)
                return first != null;
            else
                return current.next != null;
        }

        /**
         Moves the iterator past the next element.
         @return the traversed element
         */
        public Object next()
        {
            boolean hasNext = hasNext();
            if (!hasNext)
                throw new NoSuchElementException();
            //when pointing the current one to the current.next(line 115 does this),
            // ensure the current is assigned to previous
            previous = current; // Remember for remove

            if (current == null)
                current = first;
            else
                current = current.next;

            return current.data;
        }

        /**
         Adds an element before the iterator current
         and moves the iterator past the inserted element.
         @param element the element to add
         */
        public void add(Object element)
        {
            if (current == null)
            {
                addFirst(element);
                current = first;
            }
            else
            {
                // Really doubt this implementation.
                // Check what should have been the actual requirement
                // Dont remember but it should have been part of the linkedlist class
                Node newNode = new Node();
                newNode.data = element;
                newNode.next = current.next;
                current.next = newNode;
                // newNode.next = current;
                current = newNode;
            }
            previous = current;
        }

        /**
         Removes the last traversed element. This method may
         only be called after a call to the next() method.
         */
        public void remove()
        {
            if (previous == current)
                throw new IllegalStateException();

            if (current == first)
            {
                removeFirst();
            }
            else
            {
                previous.next = current.next;
            }
            current = previous;
        }

        /**
         Sets the last traversed element to a different value.
         @param element the element to set
         */
        public void set(Object element)
        {
            if (current == null)
                throw new NoSuchElementException();
            current.data = element;
        }

        public boolean hasPrevious() {
            return false;
        }

        public Object previous() {
            return null;
        }

        public int nextIndex() {
            return 0;
        }

        public int previousIndex() {
            return 0;
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object manojElement = "first insert";
		LinkedList manoj = new LinkedList();
		System.out.println(manoj);
		manoj.addFirst(manojElement);
        System.out.println("showing the first insert: " + manoj.getFirst());
        manoj.addFirst("Second insert");

        LinkedListIterator iterator = (LinkedListIterator) manoj.listIterator();
        iterator.add("adding element through iterator");
        iterator.add("adding second element through iterator");

        while(iterator.hasNext()){
            System.out.println("Printing the iterator: "+ iterator.next());
        }
	}
}

