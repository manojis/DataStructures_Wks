package com.HackerRank.Algorithms;

import com.sorting.ArrayUtil;

import java.util.Arrays;
import java.util.Scanner;
/**
 * Created by Manoj.Mohanan Nair on 10/20/2016.
 */

public class maximum_subarray {

    public int maxSubArray(int[] A) {
        int newsum = A[0];
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            newsum = Math.max(newsum + A[i], A[i]);
            if(newsum>max){
                max= newsum;
            }
            //or the below step
            //max = Math.max(max, newsum);
        }
        return max;
    }

    public int maxSubArraySecondOne(int[] A){
        int size = A.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

        for (int i = 0; i < size; i++)
        {
            max_ending_here = max_ending_here + A[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }



    public static void main(String[] args){

        int[] arr = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("input:"+ Arrays.toString(arr));
        maximum_subarray maxarr = new maximum_subarray();
        int max = maxarr.maxSubArray(arr);


        int[] arrduplicate = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("input:"+ Arrays.toString(arrduplicate));
        int maxi = maxarr.maxSubArraySecondOne(arrduplicate);

        System.out.println(max + " "+maxi);
    }
}
