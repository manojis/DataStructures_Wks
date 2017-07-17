package com.HackerRank.Algorithms;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created by Mohitha on 7/14/2017.
 */
public class DeltaEncoding {
    public static void main(String[] args) throws java.lang.Exception {
        /*int[] input = new int[]{25626,25757,24367,24267,16,100,2,7277};
        DeltaEncoding code = new DeltaEncoding();
        code.output(input);*/
        DecimalFormat df = new DecimalFormat("###.###");
        //String val = df.format(20/15);
        float val = (float) 15 / 15;
        val = Float.parseFloat(String.format("%.2f", val));
        System.out.println(val);
    }

   /* private void output(int[] arr){

        ArrayList<Integer> output = new ArrayList<Integer>();
        int diff=0;
        output.add(arr[0]);
        for(int i=1;i<arr.length;i++){

            diff = arr[i]-arr[i-1];

            if(diff>127 || diff<-127){
                output.add(-128);
                output.add(diff);
            }else{
                output.add(diff);
            }

        }
        System.out.println(output + " " + arr.length);
    }*/

}
