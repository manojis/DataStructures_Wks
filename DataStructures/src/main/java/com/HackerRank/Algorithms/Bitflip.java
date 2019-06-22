package com.HackerRank.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Manoj.Mohanan Nair
 * @Date 6/20/19
 */
public class Bitflip {
    public static void main(String[] args) {
        // change your inputs here
        //int[] input = {0,0,0,1,0,1};
        int[] input = {0, 1, 0, 0, 1, 1, 0, 1, 0};
        System.out.println(Arrays.toString(input));
        int oldcount = 0;
        int count = 0;
        int pointer = 0;
        boolean conversion = false;
        int length = input.length;
        List<Integer> formatted = new ArrayList<Integer>();
        for(int i=0;i<input.length;i++){
            System.out.println("value of i:"+ i + " "+ count);
            if(input[i]!=0 && !conversion) {
                while(input[i]!=0){
                    System.out.println("value of i in while:"+ i+ " "+ count);
                    pointer = i;
                    conversion = true;
                    formatted.add(0);
                    i++;
                    count++;
                }
                i--;
            }
            else if(input[i]!=0 && i<length-1){
                System.out.println("value of i in else if:"+ i+ " "+ count);
                if(oldcount<count){
                    oldcount = count;
                    count = 0;
                    conversion = false;
                    formatted.clear();
                }
                i = pointer;
            }else if(input[i]==0){
                System.out.println("value of i in else:"+ i+ " "+ count);
                formatted.add(input[i]);
                count++;
            }
        }
        if(oldcount>count) {
            System.out.println("final result:"+ oldcount);
        } else {
            System.out.println("final result:"+ count);
        }

    }
}
