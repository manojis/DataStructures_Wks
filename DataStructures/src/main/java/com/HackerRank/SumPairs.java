package com.HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Manoj.Mohanan Nair
 * @Date 6/21/19
 */
public class SumPairs {
    public static void main(String[] args){
        HashMap<Integer,Integer> input = new HashMap<Integer,Integer>();
        ArrayList<ArrayList> inputList = new ArrayList<>();

        int[] arrInput = {4,6,10,0,1,7,3,11,54,-1};
        int sum = 10;
        for(int n : arrInput){
            input.put(n,1);
        }
        if(!input.isEmpty()){
            for(int x: arrInput){
                ArrayList<Integer> subList = new ArrayList<>();
                int diff = sum - x;
                if(input.containsKey(diff) && input.get(diff)>0){
                    subList.add(x);
                    subList.add(diff);
                    input.put(diff,0);
                    input.put(x,0);
                }
                if(subList.size()>0){
                    inputList.add(subList);
                }
            }
        }
        System.out.println("Testing it"+ Arrays.toString(inputList.toArray()));
    }
}
