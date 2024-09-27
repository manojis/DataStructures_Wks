package com.leetcode.leetcode75;

import java.util.ArrayDeque;
import java.util.Deque;

public class MovingAverageDataStream_346 {

    Deque<Integer> deque = new ArrayDeque<>();
    int sum=0;
    double avg=0;
    int size=0;
    int count = 0;

    public MovingAverageDataStream_346(int size) {
        this.size = size;
    }

    public double next(int val) {
        // if the size of the deque is greater or equal to 3
        if (count >= size) {
            int remVal = deque.poll();
            deque.offer(val);
            sum = sum + val - remVal;
            avg = sum * 1.0/size;
        } else {
            deque.offer(val);
            count++;
            sum = sum + val;
            avg = sum*1.0/count;
        }
        return avg;
    }

    public static void main(String[] args) {
        MovingAverageDataStream_346 m = new MovingAverageDataStream_346(3);
        System.out.println(m.next(1));   // Output: 1.0
        System.out.println(m.next(10));  // Output: 5.5
        System.out.println(m.next(3));   // Output: 4.66667
        System.out.println(m.next(5));   // Output: 6.0
    }
}
