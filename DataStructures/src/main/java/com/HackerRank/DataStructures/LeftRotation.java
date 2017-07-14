package com.HackerRank.DataStructures;

/**
 * Created by Manoj.Mohanan Nair on 1/24/2017.
 */
import java.util.*;

public class LeftRotation {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner scan  = new Scanner(System.in);
        int arrlength = scan.nextInt();
        int [] arr= new int[]{1,2,3,4,5};
        int rotate = scan.nextInt();
        System.out.println(Arrays.toString(arr));
        /*for(int i=0; i<arrlength;i++)
        {
            arr[i] = scan.nextInt();
        }*/
        if(rotate < arrlength){
            for(int j=0;j<rotate;j++){
                int oldVal = arr[0];
                LeftRotation sol = new LeftRotation();
                arr = sol.rotate(arr,oldVal);

            }
        }else{
            System.out.println("Invalid Input");
        }
        System.out.println(Arrays.toString(arr));
    }

    public int[] rotate(int [] arr, int oldVal){
        int arrLen = arr.length;
        for(int i = 1;i<arrLen;i++){
            arr[i-1] = arr[i];
        }
        arr[arrLen-1] = oldVal;
        return arr;
    }
}
