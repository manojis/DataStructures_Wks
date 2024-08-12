package com.leetcode.leetcode75;

import java.util.Arrays;

public class productExceptSelf {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        int [] Output = solution(nums);
        //System.out.println(Arrays.toString(Output));
    }

    public static int[] solution(int[] nums) {

        int length = nums.length;
        int[] Output = new int[length];
        int[] forw = new int[length];
        int[] back = new int[length];
        int i=0;
        // initializing start and end array with 1
        //Output[0] = 1;
        //Output[length-1] = 1;
        forw[0] = 1;
        back[length-1] = 1;
        // 1,2,3,4,5
        // 2.3.4.5  1.3.4.5   1.2.4.5  1.2.3.5 1.2.3.4
        for(i =1; i<length; i++) {
            forw[i] = nums[i-1] * forw[i-1];
            back[length-1-i] = nums[length-1-(i-1)] * back[length-1-(i-1)];
        }
        for (i =0 ; i<length; i++) {
            Output[i] = (forw[i]) * (back[i]);
        }
        return Output;
    }
}
