package com.QueuePrograms;

import java.util.PriorityQueue;

/**
 * Created by Manoj.Mohanan Nair on 4/16/2017.
 */
public class QueueTest {

    public static void main(String[] args) {
        //Queue and Deque(double ended Queue)is an interface and cannot be instantiated.
        // Hence its implementation needs to be used like PriorityQueue
        PriorityQueue<String> qu = new PriorityQueue<String>();


        qu.add("manvi");
        qu.add("arya");
        qu.add("manoj");

        while (qu.size() > 0) {
            String name = qu.poll();
            System.out.println(name);
            System.out.println("rest of the queue:" + qu);
        }

    }
}
