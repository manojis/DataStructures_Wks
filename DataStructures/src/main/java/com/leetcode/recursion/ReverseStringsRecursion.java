package com.leetcode.recursion;

/**
 * @author Manoj.Mohanan Nair
 * @Date 9/11/19
 */
public class ReverseStringsRecursion {
    public static void main(String[] args){
        String str = "I am getting better and better";
        ReverseStringsRecursion restr = new ReverseStringsRecursion();
        char[] output = restr.reverse(str.toCharArray());
        System.out.println(output);
    }
    // reversing the string without using any collections or buffer array
    // WITH RECURSION
    public char[] reverse(char[] input) {
        int n=0;
        int size = input.length;
        for(int index=0; index<=size; index++){
            // System.out.println("character here: "+input[index]);
            if(index == size || input[index]==' ' ){
                reverseWord(input, n, index-1);
                n=index+1;
            }
        }
        return input;
    }

    public void reverseWord(char[] input, int index, int size){
        // actual logic for reversing each word by using a single char "temp"
        while(index<size){
            char temp = input[index];
            input[index]=input[size];
            input[size]=temp;
            index++;
            size--;
        }
    }
}
