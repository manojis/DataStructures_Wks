package com.tutort;

/**
 * Given an array of size N and you have to tell whether the array is perfect or not. An array is said
 * to be perfect if it's reverse array matches the original array. If the array is perfect then print
 * "PERFECT" else print "NOT PERFECT".
 */
public class ForwardNBackwardloop {
    public static void main(String args[]) {
        int[] input = {3,1,5,6,6,5, 1,3};
        boolean output = isForwardsBackwardsLoop(input);
        if(output) {
            System.out.println("PERFECT");
        } else {
            System.out.println("Not PERFECT");
        }
    }
    private static boolean isForwardsBackwardsLoop(int[] input) {
        int size = input.length;
        for(int i=0; i < size/2; i++ ) {
            if (input[i] != input[size-(i+1)]) {
                return false;
            }
        }
        return true;
    }
}
