package com.QueuePrograms;

/**
 * Created by 212561694 on 6/11/2017.
 */

import java.lang.*;

/* Name of the class has to be "Main" only if the class is public. */
class StackVal {
    private static int[] aInteger;
    private int size = 0;

    //constructor for the class
    public StackVal(int variableSize) {
        size = variableSize;
        aInteger = new int[variableSize];
    }

    public void push(int element) {

        if (aInteger.length == size)
            resize(size);

        aInteger[size++] = element;
    }

    public void resize(int capacity) {
        System.out.println(capacity);
        capacity = capacity * 2;
        System.out.println("capacity" + capacity);
        int[] aNewInteger = new int[capacity];
        for (int x = 0; x < aInteger.length; x++) {
            aNewInteger[x] = aInteger[x];
        }
        aInteger = aNewInteger;
        System.out.println("value " + aInteger.length);
    }

    public int pop() {
        int val = aInteger[size--];
        //if resize required check for the 1/4th of the array size and remove the half
        return val;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) throws java.lang.Exception {
        StackVal st1 = new StackVal(3);
        st1.push(5);

        st1.push(6);
        for (int x : aInteger) {
            System.out.println(x);
        }
        System.out.println(st1);
    }
    //using x as the pivot, head as the parent node and tail as the child node, do a quick sort

}

