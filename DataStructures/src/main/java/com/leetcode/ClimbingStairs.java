package com.leetcode;

public class ClimbingStairs {
    public static void main(String[] args){
        ClimbingStairs x = new ClimbingStairs();
        System.out.println(x.climbStairs(3));
    }
    public int climbStairs(int n) {
        int[] input = new int[]{1, 2};
        int count = 0;
        int index = 0;
        count = RecursionStairs(count, n, index);
        return count;
    }

    public int RecursionStairs(int count, int n, int index){

        // take each element with highest first from array and subract it
        // then call the same function with remaining steps
        // if the value is 1, call only 1's
        // if the value is 2, call either 1 or 2 - ignore
        // if the value is 0, return
        // if the value is less than the highest number in the existing list, remove that number from the list

        int[] input = new int[]{2, 1};
        for(int i = index; i<input.length; i++){
            System.out.println("input_i: "+ input[i]);
            int rmb = n - input[i];

            // case of 0
            if(rmb == 0){
                System.out.println("count: "+ count);
                return count;
            }
            // case of 1
            if(rmb < input[i]){
                index = i + 1;
                RecursionStairs(count, rmb, index);
            }
            RecursionStairs(count, rmb, 0);
            count = count + 1;
            System.out.println("last count: "+count);
        }
        System.out.println("final count: "+count);
        return count;
    }
}
