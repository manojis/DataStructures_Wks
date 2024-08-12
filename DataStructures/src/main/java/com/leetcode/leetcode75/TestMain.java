package com.leetcode.leetcode75;

public class TestMain {
    public static void main(String[] args) {
        int output = fibonacci(8);
        System.out.println("Hello World!"+output);
    }
    private static int fibonacci(int n) {
        int[] arr = new int[n];
        arr[0] = 0;
        arr[1] = 1;
        for(int i=2; i<n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
            System.out.println("val: "+arr[i]);
        }
        return arr[n-1];
    }
}
