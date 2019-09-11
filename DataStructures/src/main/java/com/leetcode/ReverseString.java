package com.leetcode;

/**
 * @author Manoj.Mohanan Nair
 * @Date 9/10/19
 */
public class ReverseString {
    public static void main(String[] args){
        String str = "This is my cat";
        ReverseString restr = new ReverseString();
        char[] output = restr.reverse(str.toCharArray());
        System.out.println(output);
    }

    // reversing the string without using any collections or buffer array
    public char[] reverse(char[] input){
        int n = 0;
        int index = 0;
        int prev = 0;
        int size = input.length;

        while(size > 0){
            n = index;
            for(int j = index; j < size; j++){
                if(Character.isWhitespace(input[j])){
                    break;
                }
                index++;
            }
            int count = prev + (index - prev) / 2;
            // actual logic for reversing each word by using a single char "temp"
            for(int i = index-1; i >= count; i--){
                char temp = input[i];
                input[i] = input[n];
                input[n] = temp;
                n++;
            }
            if(index > size){
                return input;
            } else {
                index++;
                prev = index;
            }
        }
        // if size = 0, return empty array
        return input;
    }
}
