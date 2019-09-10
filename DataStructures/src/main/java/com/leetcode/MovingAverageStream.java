package com.leetcode;

/**
 * @author Manoj.Mohanan Nair
 * @Date 9/7/19
 */
public class MovingAverageStream {

    int index = 0;
    int curr = 0;
    int sum = 0;
    int[] inputStream;

    public MovingAverageStream(int size) {
        inputStream = new int[size];
    }
    public double next(int val){
        // if index >= 3 then dont increment
        if(index < inputStream.length){
            index++;
        }
        sum = sum - inputStream[curr];
        inputStream[curr] = val;
        sum = sum + val;
        // divider needs to start from 0,1,2,and maintain 3.
        curr = (curr + 1) % (inputStream.length);
        return (double)sum / index;
    }
    public static void main(String[] args){
        double avg = 0;
        MovingAverageStream obj1 = new MovingAverageStream(3);
        avg=obj1.next(3);
        System.out.println(avg);
        avg=obj1.next(6);
        System.out.println(avg);
        avg=obj1.next(4);
        System.out.println(avg);
        avg=obj1.next(7);
        System.out.println(avg);
        avg=obj1.next(11);
        System.out.println(avg);
        avg=obj1.next(12);
        System.out.println(avg);
        avg=obj1.next(13);
        System.out.println(avg);
    }
}
