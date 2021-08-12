package com.leetcode.dynamic;

import java.util.*;
/**
 * @author Manoj.Mohanan Nair
 * @Date 11/19/19
 *
 * Curly braces can be used in programming to provide scope-limit.
 * Write a function to print all valid( properly opened and closed) combinations of n-pairs of curly braces.
 * Example:
 * input: 1 output: {}
 * input: 2 output: {}{}, {{}}
 * input: 3 output: {}{}{}, {}{{}}, {{}}{}, {{}{}}, {{{}}}
 * If you need more classes, simply define them inline.
 */
public class GenerateParenthesis {
    public static void main(String[] args){
        System.out.println(generateParenthesis(3));
    }
    public static List<String> generateParenthesis(int n) {
        ArrayList<String> combinations = new ArrayList<String>();
        List<String> output = generateAll(combinations, n, n, "");
        return output;
    }

    public static ArrayList<String> dynaGenerate(ArrayList<String> combinations, int left, int right, String temp){
        return combinations;
    }

    // Recursive method to generate parenthesis
    public static ArrayList<String> generateAll(ArrayList<String> combinations, int left, int right, String temp)
    {
        // if the left <0 and left > right, this is illegel hence return
        if(left < 0 || left > right){
            return null;
        }
        // if the left and right = 0, then add it to combinations
        if(left==0 && right==0){
            combinations.add(temp.toString());
        }
        if(left > 0){
            generateAll(combinations, (left -1), right, temp + '{');
        }
        if(right > 0){
            generateAll(combinations, left,(right -1), temp + '}');
        }
        return combinations;
    }
}
