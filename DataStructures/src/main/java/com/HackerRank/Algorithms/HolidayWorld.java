package com.HackerRank.Algorithms;

import java.util.*;
/**
 * Created by Manoj.Mohanan Nair on 12/19/2016.
 */
//input 4[bx2[cay]]
//output bxcaycaybxcaycaybxcaycaybxcaycay

    //go to Decode String for the right answer
public class HolidayWorld {
    public static void main (String[] args) throws java.lang.Exception
    {
        String orig = "4[bx2[cay]]";
        //String orig = "b2[ca]";
        //String orig = "ca";
        HolidayWorld code = new HolidayWorld();
        code.decode(orig);
    }

    private void decode(String orig){

        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<String> stack2 = new Stack<String>();
        Stack<String> rev = new Stack<String>();


        String val = "";
        String digits = orig.replaceAll("[^0-9]","");

        String chars="";

        for(int x=0;x<digits.length();x++){
            stack1.push(Integer.parseInt(String.valueOf(digits.charAt(x))));
        }

        for(int i=0; i<orig.length();i++){

            chars = String.valueOf(orig.charAt(i));

            if((Character.isAlphabetic(chars.charAt(0))) || ("[".equals(chars))){
                stack2.push(chars);

            } else if(("]".equals(chars))){
                while(!"[".equals(stack2.peek())){
                    rev.push(stack2.pop());
                }
                if("[".equals(stack2.peek())){
                    stack2.pop();
                }

                String temp ="";
                while(!rev.isEmpty()){
                    temp = temp + rev.pop();
                }
                int count = stack1.pop();
                for(int j=0;j<count;j++){
                    val = temp + val;
                }
            }
        }
        System.out.println(val);
    }
}
