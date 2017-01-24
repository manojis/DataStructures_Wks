
package com.Misc;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class groupon {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */


        Scanner scan  = new Scanner(System.in);
        int arrlength = scan.nextInt();
        int [] arr = new int[arrlength];
        int rotate = scan.nextInt();
        for(int i=0; i<arrlength;i++)
        {
            arr[i] = scan.nextInt();
        }
        if(rotate < arrlength){
            for(int j=0;j<rotate+1;j++){
                int oldVal = arr[0];
                groupon sol = new groupon();
                sol.rotate(arr,oldVal);
            }
        }else{
            System.out.println("Invalid Input");
        }
    }

    public void rotate(int [] arrs, int oldVal){
        int arrLen = arrs.length;
        for(int i = 1;i<arrLen;i++){
            arrs[i-1] = arrs[i];
        }
        arrs[arrLen] = oldVal;
    }
}
