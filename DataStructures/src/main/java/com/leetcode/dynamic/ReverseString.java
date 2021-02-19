package com.leetcode.dynamic;

import java.util.ArrayList;

/**
 * @author Manoj.Mohanan Nair
 * @Date 9/9/19
 */

// Reversing a string using recursion approach
public class ReverseString {
    public static void main(String[] args){

        String input = "ABC123";
        String output = reverseString(input);
        System.out.println("the output is: " + output);
    }

    public static String reverseString(String input){
        String first = input.substring(0,1);
        String second = input.substring(1);
        if(second.length()<=1){
            return second + first;
        }
        second = reverseString(second);
        String output =second + first;
        System.out.println("Inside the recursion: " + output);
        return output;
    }
}
