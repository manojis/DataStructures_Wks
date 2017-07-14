package com.stackAndQueue;

import java.util.NoSuchElementException;

/**
 * Created by 212561694 on 1/1/2017.
 *
 * Stack push() and pop() implemented as a linkedlist
 */
public class LinkedListStack
{
    private Node first;
    public class Node
    {
        private Object data;
        private Node next;
    }

    public LinkedListStack()
    {
        first = null;
    }

    public Object getFirst()
    {
        if (first == null)
            throw new NoSuchElementException();
        return first.data;
    }
    /*pushes the element to top of the stack
    *which is similar to addfirst() in linkedlist
    */
    public void push(Object element){
    	System.out.println("Enter push " +first);
            Node newNode = new Node();
            newNode.data = element;
            newNode.next = first;
            System.out.println("After first next assign " +first);
            first = newNode;
            System.out.println("Enter Change " +first);
    }

    /*returns the element from the top of the stack
    * which is similar to removing the first node from the linkedlist i.e removeNode()
    */
    public Object pop(){
        if(first == null){
            throw new NoSuchElementException();
        }
        else
        {
            Object element = first.data;
            first = first.next;
            return element;
        }
    }

    public static void main(String[] args){

        LinkedListStack stack = new LinkedListStack();
        stack.push("sss");
        stack.push("got it");
        System.out.println("Enter stack " +stack);

    }
}
