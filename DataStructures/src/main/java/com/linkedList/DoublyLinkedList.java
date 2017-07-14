package com.linkedList;

/**
 * Created by Manoj.Mohanan Nair on 1/1/2017.
 */
import com.sorting.ArrayUtil;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<Item> implements Iterable<Item> {
    private int n;        // number of elements on list
    //A linked list object holds a reference to the head node, and each node holds a reference to the next node
    private Node head;     // sentinel before first item
    //A linked list object holds a reference to the tail node, and each node holds a reference to the next node
    private Node tail;    // sentinel after last item

    // linked list node helper data type
    private class Node {
        private Item item;
        private Node next;
        private Node previous;
    }

    public boolean isEmpty()
    {
        return n == 0;
    }
    public int size()
    {
        return n;
    }

    public DoublyLinkedList() {
        head  = new Node();
        tail = new Node();
        head.next = tail;
        tail.previous = head;
        
    }
    // add the item to the list
    public void add(Item item)
    {
        Node last = tail.previous;
        Node x = new Node();
        x.item = item;
        x.next = tail;
        x.previous = last;
        tail.previous = x;
        last.next = x;
        n++;
    }

    public ListIterator<Item> iterator()
    {
        return new DoublyLinkedListIterator();
    }

    // assumes no calls to DoublyLinkedList.add() during iteration
    private class DoublyLinkedListIterator implements ListIterator<Item>
    {
        private Node current      = head.next;  // the node that is returned by next()
        private Node lastAccessed = null;      // the last node to be returned by prev() or next()
        // reset to null upon intervening remove() or add()
        private int index = 0;

        public boolean hasNext()      { return index < n; }
        public boolean hasPrevious()  { return index > 0; }
        public int previousIndex()    { return index - 1; }
        public int nextIndex()        { return index;     }

        public Item next()
        {
            if (!hasNext()) throw new NoSuchElementException();
            lastAccessed = current;
            Item item = current.item;
            current = current.next;
            index++;
            return item;
        }

        public Item previous()
        {
            if (!hasPrevious()) throw new NoSuchElementException();
            current = current.previous;
            index--;
            lastAccessed = current;
            return current.item;
        }

        // replace the item of the element that was last accessed by next() or previous()
        // condition: no calls to remove() or add() after last call to next() or previous()
        public void set(Item item)
        {
            if (lastAccessed == null)
                throw new IllegalStateException();
            lastAccessed.item = item;
        }

        // remove the element that was last accessed by next() or previous()
        // condition: no calls to remove() or add() after last call to next() or previous()
        public void remove()
        {
            if (lastAccessed == null)
                throw new IllegalStateException();
            Node x = lastAccessed.previous;
            Node y = lastAccessed.next;
            x.next = y;
            y.previous = x;
            n--;
            if (current == lastAccessed)
                current = y;
            else
                index--;
            lastAccessed = null;
        }

        // add element to list
        public void add(Item item)
        {
            Node x = current.previous;
            Node y = new Node();
            Node z = current;
            y.item = item;
            x.next = y;
            y.next = z;
            z.previous = y;
            y.previous = x;
            n++;
            index++;
            lastAccessed = null;
        }
    }

    public String toString()
    {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }

    // a ParenthesisCheck client
    public static void main(String[] args)
    {
        int n  = Integer.parseInt(args[0]);
        // add elements 1, ..., n
        System.out.println(n + " random integers between 0 and 99");
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        for(int x : ArrayUtil.randomIntArray(10,100))
        {
            list.add(x);
        }
        System.out.println(list);

        ListIterator<Integer> iterator = list.iterator();
        // go forwards with next() and set()
        System.out.println("add 1 to each element via next() and set()");
        while (iterator.hasNext()) {
            int x = iterator.next();
            iterator.set(x + 1);
        }
        System.out.println(list);
        System.out.println();

        // go backwards with previous() and set()
        System.out.println("multiply each element by 3 via previous() and set()");
        while (iterator.hasPrevious())
        {
            int x = iterator.previous();
            iterator.set(x + x + x);
        }
        System.out.println(list);
        System.out.println();


        // remove all elements that are multiples of 4 via next() and remove()
        System.out.println("remove elements that are a multiple of 4 via next() and remove()");
        while (iterator.hasNext())
        {
            int x = iterator.next();
            if (x % 4 == 0) iterator.remove();
        }
        System.out.println(list);
        System.out.println();


        // remove all even elements via previous() and remove()
        System.out.println("remove elements that are even via previous() and remove()");
        while (iterator.hasPrevious())
        {
            int x = iterator.previous();
            if (x % 2 == 0) iterator.remove();
        }
        System.out.println(list);
        System.out.println();


        // add elements via next() and add()
        System.out.println("add elements via next() and add()");
        while (iterator.hasNext())
        {
            int x = iterator.next();
            iterator.add(x + 1);
        }
        System.out.println(list);
        System.out.println();

        // add elements via previous() and add()
        System.out.println("add elements via previous() and add()");
        while (iterator.hasPrevious())
        {
            int x = iterator.previous();
            iterator.add(x * 10);
            iterator.previous();
        }
        System.out.println(list);
        System.out.println();
    }
}

