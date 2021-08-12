package com.leetcode.dynamic;

/**
 * @author Manoj.Mohanan Nair
 * @Date 11/21/19
 * Cracking the code pblm-2 and Leetcode-62
 */
public class Robot_Grid {
    public static void main(String[] args){
        int out = uniquePaths_recursion(7,3);
        System.out.println("output is: "+ out);
    }

    // by recursion
    public static int uniquePaths_recursion(int m, int n) {
        if(m==1 || n==1){
            return 1;
        }else {
            return uniquePaths_recursion(m-1, n) + uniquePaths_recursion(m, n-1);
        }
    }

    // by Dynamic programming
    public static int uniquePaths(int m, int n) {
        Integer[][] output = new Integer[m][n];
        for(int r=0; r< m; r++){
            output[r][0] = 1;
        }
        for(int c = 0; c< n; c++){
            output[0][c] = 1;
        }

        for(int r=0; r< m; r++){
            for(int c=1; c<n; c++){
                output[r][c] = output[r-1][c] + output[r][c-1];
                System.out.println(output[r][c]);
            }
        }
        return output[m-1][n-1];
    }
}
