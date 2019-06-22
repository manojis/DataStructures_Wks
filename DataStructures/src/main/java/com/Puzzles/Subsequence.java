package com.Puzzles;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Manoj.Mohanan Nair
 * @Date 9/16/18
 */
public class Subsequence {

    static int arr[] = new int[]{1, 2, 3, 4};

    static void printSubsequences(int n)
    {
        /* Number of subsequences is (2**n -1)*/
        int opsize = (int)Math.pow(2, n);

        /* Run from counter 000..1 to 111..1*/
        for (int counter = 1; counter < opsize; counter++)
        {
            ArrayList<Integer> sub = new ArrayList<>();
            for (int j = 0; j < n; j++)
            {
                /* Check if jth bit in the counter is set
                    If set then print jth element from arr[] */
                if (BigInteger.valueOf(counter).testBit(j)) {
                    sub.add(arr[j]);
                }
            }

            int[] res =  sub.stream().filter(t -> t != null).mapToInt(t -> t).toArray();
            System.out.println(Arrays.toString(res));
            System.out.println();
        }
    }

    // Driver method to test the above function
    public static void main(String[] args)
    {
        System.out.println("All Non-empty Subsequences");
        printSubsequences(arr.length);
    }
}
