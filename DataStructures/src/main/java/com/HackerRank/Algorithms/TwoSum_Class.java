package com.HackerRank.Algorithms;

import java.util.*;
import java.io.*;
/**
 * @author Manoj.Mohanan Nair
 * @Date 8/10/2017
 * input: 3,4,4,7,6 and find 10(sum of two numbers)
 * output: True
 */

public class TwoSum_Class {

    private static HashMap<Integer,Integer> hMap = new HashMap<Integer,Integer>();

    public static void main(String[] args){

        TwoSum_Class mc = new TwoSum_Class();

        add(3);
        add(4);
        add(4);
        add(7);
        add(6);
        boolean found = find(10);
        System.out.println("found:"+found);
    }

    public static void add(int input){
        if(hMap!=null && hMap.containsKey(input)){
            hMap.put(input,hMap.get(input)+1);
        }else{
            hMap.put(input,1);
        }
    }

    public static boolean find(int value){
        int firstNumber = 0;
        int secondNumber = 0;
        for(Map.Entry<Integer,Integer> entry: hMap.entrySet()){
            firstNumber = entry.getKey();
            secondNumber = value-firstNumber;

            if(firstNumber==secondNumber){
                if(hMap.get(secondNumber).equals(2)){
                    return true;
                }
            } else if(hMap.containsKey(secondNumber) && hMap.get(secondNumber)!=2){
                return true;
            }
        }
        return false;
    }
}
