package com.Misc;

import com.sorting.ArrayUtil;

import java.util.Scanner;
/**
 * Created by 212561694 on 10/20/2016.
 */
public class max_subarr {

    public int maxSubArray(int[] A) {
        int newsum = A[0];
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            newsum = Math.max(newsum + A[i], A[i]);
            max = Math.max(max, newsum);
        }
        return max;
    }

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        int length = scan.nextInt();
        int range = scan.nextInt();
        int[] arr = ArrayUtil.randomIntArray(length,range);
        max_subarr maxarr = new max_subarr();
        int max = maxarr.maxSubArray(arr);
        System.out.println(max);
    }
}
