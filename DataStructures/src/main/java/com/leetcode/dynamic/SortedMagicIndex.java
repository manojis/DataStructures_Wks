package com.leetcode.dynamic;

public class SortedMagicIndex {
    public static void main(String[] args) {
        int A[] = new int[]{-1,0,1,2,4,10};
        System.out.println(printIndex(A, 0, (A.length -1)));
    }

    public static int printIndex(int[] a, int start, int end) {
        int mid = start + end /2;
        if (a[mid] == mid) {
            return mid;
        }else if (a[mid] > mid){
            return printIndex(a, start, mid -1);
        }else {
            return printIndex(a, mid, end-1);
        }
    }
}
