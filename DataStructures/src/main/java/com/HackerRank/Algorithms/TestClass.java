package com.HackerRank.Algorithms;

import java.util.HashMap;
import java.util.Map;

public class TestClass {

    private HashMap<Integer,Integer> hMap = new HashMap<Integer,Integer>();

    public static void main (String[] args) throws java.lang.Exception
    {
       int value = 65;
       int check_bit = 1 << 6;
       int and_bit =  value & check_bit;
        System.out.println(and_bit);
       if(and_bit == check_bit){
           System.out.println(1);
       } else {
           System.out.println(0);
       }
        /*TestClass tc = new TestClass();
        tc.add(4);
        tc.add(5);
        tc.add(6);
        tc.add(4);
        tc.add(8);
        System.out.println("ok");*/
    }

    public void add(int value){
        int count =0;
        if(hMap!=null && hMap.containsKey(value)){
            count = hMap.get(value);
            count++;
            hMap.put(value,count);
            //System.out.println(hMap.get(value));
        }else{
            count =1;
            hMap.put(value,count);
        }
        for(Map.Entry<Integer,Integer> entry: hMap.entrySet()){
            System.out.println(entry.getKey()+" . "+entry.getValue());
        }
    }
}
