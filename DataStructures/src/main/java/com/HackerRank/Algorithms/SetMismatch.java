package com.HackerRank.Algorithms;

import java.util.Arrays;
/**
 * @author Manoj.Mohanan Nair
 * @Date 7/10/2017
 */
public class SetMismatch {
    public static void main (String[] args) throws java.lang.Exception
    {
        System.out.println("Hello Java");
        int[] input = new int[]{1,2,2,5,5};
        int[] output = mismatch(input);
        System.out.println("output" +Arrays.toString(output));
    }

    public static int[] mismatch(int[] nums){

        int[] result = new int[2];
        for (int i : nums) {
            System.out.println("first value: "+Math.abs(i) + " %%  "+nums[Math.abs(i) - 1]);
            if (nums[Math.abs(i) - 1] < 0){
                result[0] = Math.abs(i);
            }
            else {
                System.out.println("first value: "+Math.abs(i));
                nums[Math.abs(i) - 1] *= -1;
                System.out.println("After first value change: "+Math.abs(i));
            }
        }
        for (int i=0;i<nums.length;i++) {
            if (nums[i] > 0) {
                result[1] = i+1;
            }
        }
        //int[] result = Arrays.copyOf(tempResult,j);
        return result;
    }
}
