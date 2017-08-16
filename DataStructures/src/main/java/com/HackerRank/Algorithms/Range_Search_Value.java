package com.HackerRank.Algorithms;

import java.util.Arrays;

/**
 * @author Manoj.Mohanan Nair
 * @Date 7/10/2017
 */
/*
 input ={5,7,7,8,8,10}
 output = {3,8}
 */
public class Range_Search_Value {
    public static void main (String[] args) throws java.lang.Exception
    {
        int[] input = new int[]{5,7,7,8,8,10};
        int val = 8;
        int[] output = range(input,val);
        System.out.println(""+ Arrays.toString(output));
    }

    public static int[] range(int[] input,int val){

        int length=input.length;
        int front=0;
        int back=length-1;
        boolean bFront=false;
        boolean bBack=false;
        int[] result = new int[2];
        while(front<length && back>=0){

            if(!bFront && input[front]==val){
                bFront=true;
                result[0]=front;
            }else if(!bFront){
                front++;
            }

            if(!bBack && input[back]==val){
                bBack=true;
                result[1]=back;
            }else if(!bBack){
                back--;
            }

            if(bFront&&bBack){
                break;
            }

        }
        return result;
    }
}
