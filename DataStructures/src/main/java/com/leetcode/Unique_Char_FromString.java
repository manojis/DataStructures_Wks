package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author Manoj.Mohanan Nair
 * @Date 11/20/19
 * Asked in MBRDNA Phone Interview along with Generate Parenthesis Question.
 */
public class Unique_Char_FromString {
    public static void main(String[] args) {
        String x = "Mercedes";
        char[] input = x.toCharArray();
        String output = outputCollection(input);
        System.out.println(output);
    }
    public static String outputCollection(char[] input){
        ArrayList<Character> output = new ArrayList<>();
        HashSet<Character> temp = new HashSet<>();

        for(char in : input){
            if(!temp.contains(in)){
                // as a buffer for O(1) search
                temp.add(in);
                // add to list
                output.add(in);
            }
        }
        return output.toString();
    }
}
