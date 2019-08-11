package com.ctci;

import java.util.Arrays;

/**
 * @author Manoj.Mohanan Nair
 * @Date 08/10/19
 */

public class permutation {
    public static void main(String[] args) {
        String a = "god";
        String b = "dog";
        permutation mains = new permutation();
        System.out.println("Two strings are permutatable: "+mains.permutation(a, b));

    }

    public boolean permutation(String a, String b){

        char[] inputA = a.toCharArray();
        char[] inputB = b.toCharArray();
        Arrays.sort(inputA);
        Arrays.sort(inputB);

        String xa = new String(inputA);
        String xb = new String(inputB);
        if(xa.equals(xb)){
            return true;
        }else{
            return false;
        }
    }


}
