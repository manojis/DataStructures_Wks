package com.HackerRank.Algorithms;

import java.util.Stack;

/**
 * @author Manoj.Mohanan Nair
 * @Date 8/11/17
 */
//input 4[bx2[cay]]
//output bxcaycaybxcaycaybxcaycaybxcaycay

public class DecodeString {

    public static void main(String[] args){
        String input = "4[bx2[cay]]";

        String output = decodeString(input);
        System.out.println(output);
    }

    public static String decodeString(String orig) {
        String output = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;

        while (idx < orig.length()) {
            if (Character.isDigit(orig.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(orig.charAt(idx))) {
                    count = 10 * count + (orig.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            }
            else if (orig.charAt(idx) == '[') {
                resStack.push(output);
                output = "";
                idx++;
            }
            else if (orig.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder (resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(output);
                }
                output = temp.toString();
                idx++;
            }
            else {
                output += orig.charAt(idx++);
            }
        }
        return output;
    }
}
