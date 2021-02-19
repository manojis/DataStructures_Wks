package com.algo6515.HW6515;

/**
 * @author Manoj.Mohanan Nair
 * @Date 2/19/21
 */
public class MaxProductOperator {
    public static void main(String [] args){
        System.out.println("Output max product: " + solve("48567", 2));
    }

    static long solve(String digits, int operator)
    {
        if (operator == 0)
            return Long.parseLong(digits);

        // Preprocessing - set up substring values
        long[][] substrings = new long[digits.length()][digits.length()+1];
        for (int i = 0; i < digits.length(); i++){
            for (int j = i+1; j <= digits.length(); j++){
                substrings[i][j] = Long.parseLong(digits.substring(i, j));
            }
        }

        // Calculate multiplications from the left
        long[][] A = new long[digits.length()][operator+1];
        A[0][0] = 1;
        int aLength = A.length;
        for (int i = 1; i < A.length; i++)
        {
            A[i][0] = substrings[0][i];
            int a_0length = A[0].length;
            for (int j = 1; j < A[0].length; j++)
            {
                long max = -1;
                for (int k = 0; k < i; k++)
                {
                    long l = substrings[k][i];
                    long s = A[k][j-1];
                    System.out.println(l + " " + s);
                    long prod = l * s;
                    max = Math.max(max, prod);
                }
                A[i][j] = max;
                System.out.println("i: "+i + " j: "+ j + " A[i][j]: "+A[i][j]);
            }
        }

        // Multiply left with right and find maximum
        long max = -1;
        for (int i = 1; i < A.length; i++)
        {
            System.out.println("i: "+i + " substrings[i][A.length]: "
                    + substrings[i][A.length] + "A[i][operator]: "+A[i][operator]);
            max = Math.max(max, substrings[i][A.length] * A[i][operator]);
        }
        return max;
    }
}
