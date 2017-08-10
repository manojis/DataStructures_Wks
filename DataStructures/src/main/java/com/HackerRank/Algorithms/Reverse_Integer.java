package com.HackerRank.Algorithms;

//inpout = 123
//output = 321


//inpout = -123
//output = -321

//input = 1000000003
//output = reverse of 1000000003 overflows and hence return as 0
/**
 * @author Manoj.Mohanan Nair
 * @Date 7/10/2017
 */

public class Reverse_Integer {
    public static void main(String[] args){

        int input = -123;
        int reversed = reverse(input);
        System.out.println("  "+reversed);
    }

    public static int reverse(int value){

        int result =0;

        while(value!=0){
            int tail = value%10;
            result = result * 10 + tail;

            if(result>Integer.MAX_VALUE || result<Integer.MIN_VALUE){
                return 0;
            }
            value = value/10;
        }
        return result;
    }
}
