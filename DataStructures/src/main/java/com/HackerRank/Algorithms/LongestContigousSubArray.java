package com.HackerRank.Algorithms;

/**
 * Created by Mmanoj.Mohanan Nair on 7/23/2017.
 */
public class LongestContigousSubArray {

    public static void main(String[] args) throws java.lang.Exception {
        int[] a = {1, 2, 3, 0, 5, 19, 23, 45, -1, -2, 10};

        int[] startEnd = solve(a);

        for (int i = startEnd[0]; i <= startEnd[1]; i++) {
            System.out.print(a[i] + " ");
        }
    }

    private static int[] solve(int[] a) {
        int[] ans = new int[2];
        int max = 1;
        int i = 0;

        while (i < a.length - max) {
            boolean skip = false;
            int j = i + max;
            while (j > i) {
                if (a[j] <= a[j - 1]) {
                    i = j;
                    skip = true;
                    break;
                }
                j--;
            }


            if (!skip) {
                i = i + max;
                while (i < a.length && a[i] > a[i - 1]) {
                    i++;
                    max++;
                }
                ans = new int[]{i - max, i - 1};
            }
        }


        return ans;
    }
}
