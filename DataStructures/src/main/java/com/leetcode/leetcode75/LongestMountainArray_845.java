package com.leetcode.leetcode75;

/**
 * https://www.youtube.com/watch?v=AuarHcqyotY
 */
public class LongestMountainArray_845 {
    public static void main(String[] args) {
        LongestMountainArray_845 ln = new LongestMountainArray_845();
        System.out.println(ln.longestMountain(new int[]{2,1,4,7,3,2,5}));
    }
    public int longestMountain(int[] arr) {
        int maxCount = 0;
        int length = arr.length;
        int[] left = new int[length];
        int[] right = new int[length];
        left[0] = 0;
        right[length-1] = 0;

        // move from left to right and update the left index i based on if the current index is greater than previous
        // move from right to left and update the right index i based on if the current index is greater than previous
        for(int i = 1; i<length; i++) {
            if(arr[i] > arr[i-1]) {
                left[i] = left[i-1] + 1;
            }
            if(arr[(length-1)-i] > arr[(length-1)-(i-1)]) {
                right[(length-1)-i] = right[(length-1)-(i-1)]+1;
            }
        }

        for (int j=0; j<length; j++) {
            int temp=0;
            if(left[j] >0 && right[j]>0) {
                temp = left[j] + right[j] +1;
            }
            if(temp > maxCount){
                maxCount = temp;
            }
        }
        return maxCount;
    }
}
