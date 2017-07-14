package com.Misc;

import java.util.Scanner;

/**
 * Created by Manoj.Mohanan Nair on 1/8/2017.
 */
public class PyramidMaxVal {

    public static void main( String[] args){
       /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sn = new Scanner(System.in);
        int length = sn.nextInt();
        int[][] arr = new int[][]{{1,1,1,0,0,0},
                {0,1,0,0,0,0},
                {1,1,9,0,0,0},
                {0,9,2,-4,-4,0},
                {0,0,0,-2,0,0},
                {0,0,-1,-2,-4,0}};
        int total =0;
        int sum =0;
        for (int r = 0;r<length-3;r++){
            for(int c = 0;c<length-2;c++){
                System.out.println(arr[r][c] +"  " + arr[r][c+1] +"  " + arr[r][c+2] +"  " + arr[r+1][c+1] +"  " + arr[r+2][c] +"  " + arr[r+2][c+1] +"  " + arr[r+2][c+2]);
                sum = arr[r][c] + arr[r][c+1] + arr[r][c+2] + arr[r+1][c+1] + arr[r+2][c] + arr[r+2][c+1] + arr[r+2][c+2];
                if(sum > total){
                    total = sum;
                }
            }
        }
        System.out.println("total is " +total + " " + arr.length);
    }
}
