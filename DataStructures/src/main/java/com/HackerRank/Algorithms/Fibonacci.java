package com.HackerRank.Algorithms;

/**
 * @author Manoj.Mohanan Nair
 * @Date 7/10/2017
 */

import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = s.nextInt();
        int [] result = fibonacci(n);
        System.out.println("result: "+ Arrays.toString(result));
    }

    public static int[] fibonacci(int n) {

        int[] arr;
        if (n == 0) {
            arr = new int[1];
            arr[0] = 0;
        } else if (n == 1) {
            arr = new int[1];
            arr[0] = 1;
        }else {
            arr = new int[n];
            arr[1] = 1;
            int a =0;
            int b = 1;
            for (int i = 2; i <= n; i++) {
                int nextNumber = a + b;
                arr[i]=nextNumber;
                a = b;
                b = nextNumber;
            }
        }
        return arr;
    }
}

