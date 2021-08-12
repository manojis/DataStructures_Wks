package com.leetcode.dynamic;

/**
 * @author Manoj.Mohanan Nair
 * @Date 11/20/19
 * Finding the total number of ways to reach the nth stair when 1, 2, 3 steps are allowed
 */
public class Climbing_Ladder {
    public static void main(String[] args){
        int out = recursive(4);
        System.out.println("output is: "+ out);
    }

    public static int recursive(int n){

        int output[] = new int[n+2];

        for(int i = 0; i <= n ; i++){
            if(i == 0){
                output[0] = 1;
            }
            else if(i == 1){
                output[1] = 1;
            }
            else if(i == 2){
                output[2] = 2;
            }
            else {
                output[i] = output[i-1] + output[i-2] + output[i-3];
            }
        }
        return output[n];
    }
}
