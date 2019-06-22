package com.HackerRank.Algorithms;

import java.util.*;
/**
 * @author Manoj.Mohanan Nair
 * @Date 10/8/18
 */
public class Solution {

    public static void main(String[] args){


        String input = "awaglknagawunagwkwagl";
        int num = 4;
        List<String> output = subStringsKDist(input, num);
        output.forEach(k ->{
            System.out.println(k);
        });
    }


    public static List<String> subStringsKDist(String inputStr, int num)
    {
        // WRITE YOUR CODE HERE
        int arr[] = new int[num];
        List<String> output = new ArrayList<String>();
        List<Character> charList = new ArrayList<Character>();

        char[] ch = inputStr.toCharArray();
        int size = 4;

        for(int i=0; i<size; i++){
            if(!charList.contains(ch[i])){
                charList.add(ch[i]);
            }else{
                //this will maintain the last char order
                charList.remove(ch[i]);
                charList.add(ch[i]);
                size = size + 1;
            }

            if(charList.size()==4){
                StringBuilder sb = new StringBuilder(charList.size());
                for(char cha: charList){
                    sb.append(cha);
                }
                output.add(sb.toString());
                i = i-2;
                size = size + 1;
                charList = new ArrayList<Character>();
                if(size >(inputStr.length()+1)){
                    break;
                }
            }
        }
        return output;
    }
}
