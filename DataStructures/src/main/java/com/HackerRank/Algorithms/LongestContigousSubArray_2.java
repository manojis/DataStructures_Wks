package com.HackerRank.Algorithms;

import java.util.ArrayList;

/**
 * Created by Manoj.Mohanan Nair on 7/23/2017.
 */
public class LongestContigousSubArray_2 {
    public static void main(String[] args) throws java.lang.Exception {
        int[] a = {1, 2, 3, 0, 5, 19, 23, 45, -1, -2, 10};
        int[] startEnd = solve(a);
    }

    private static int[] solve(int[] input) {

        int i = 0, count = 1, previousCount = 0;
        int[] result = new int[input.length];
        ArrayList<Integer> current = new ArrayList<Integer>();
        ArrayList<Integer> previous = null;

        while (i < input.length - 1) {

            if (input[i + 1] > input[i]) {

                current.add(input[i]);
                count++;
                i++;
            } else {
                if (count > previousCount) {
                    previousCount = count;
                    count = 0;
                    previous = (ArrayList<Integer>) current.clone();
                    current.add(input[i]);
                    count++;
                }
                current.clear();
                i++;
            }
        }
        for (int j = 0; j < previous.size(); j++) {
            result[j] = previous.get(j).intValue();
        }
        return result;
    }
}
