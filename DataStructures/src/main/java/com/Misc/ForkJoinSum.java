package com.Misc;

import java.util.concurrent.*;

/**
 * @author Manoj.Mohanan Nair
 * @Date 10/20/18
 */
public class ForkJoinSum extends RecursiveTask<Long>{

    int low, high;
    int[] array;
    ForkJoinSum(int[] arr, int lo, int hi) {
        array = arr;
        low   = lo;
        high  = hi;
    }
    protected Long compute() {
        if(high - low <= 4) {
            long sum = 0;
            for(int i=low; i < high; ++i)
                sum += array[i];
            return sum;
        } else {
            int mid = low + (high - low) / 2;
            ForkJoinSum left  = new ForkJoinSum(array, low, mid);
            ForkJoinSum right = new ForkJoinSum(array, mid, high);
            left.fork();
            long rightAns = right.compute();
            long leftAns  = left.join();
            return leftAns + rightAns;
        }
    }
    static long sumArray(int[] array) {
        return new ForkJoinPool().invoke(new ForkJoinSum(array,0,array.length));
    }
}
