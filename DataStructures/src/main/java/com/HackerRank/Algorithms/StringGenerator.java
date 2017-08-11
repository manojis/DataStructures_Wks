package com.HackerRank.Algorithms;

import java.util.Stack;

/**
 * @author Manoj.Mohanan Nair
 * @Date 8/11/17
 */
//input 4[bx2[cay]]
//output bxcaycaybxcaycaybxcaycaybxcaycay
public class StringGenerator {

    public static void main(String[] args){
        String input = "4[bx2[cay]]";

        for(int i=0;i<input.length();i++){
            Character ch = input.charAt(i);
            System.out.println("input each value" + ch);
        }
        //String output = generator(input);
    }

    public void generator(String input){

        Stack<String> chars = new Stack<String>();
        Stack<String> ints = new Stack<String>();

        for(int i=0;i<input.length();i++){
            Character ch = input.charAt(i);
            System.out.println("input each value" + ch);
        }
    }
}
