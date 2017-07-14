package com.sorting.insertion;

import com.sorting.ArrayUtil;

import java.util.Arrays;

/**
 * Created by Manoj.Mohanan Nair on 12/30/2016.
 */
public class Insertion_Sort {

    private int []a;
    public Insertion_Sort(int [] numarr){
        this.a = numarr;
    }

    public int[] sort(){
        for(int i=1; i<a.length;i++){
            for(int j=i;j>0;j--)
            {
                if(a[j] < a[j-1]){
                    int temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                }
            }

        }
        return  a;
    }

    public static void main(String [] args){
        int [] arr = ArrayUtil.randomIntArray(10,100);
        Insertion_Sort ins = new Insertion_Sort(arr);
        arr = ins.sort();
        System.out.println(Arrays.toString(arr));
    }
}
