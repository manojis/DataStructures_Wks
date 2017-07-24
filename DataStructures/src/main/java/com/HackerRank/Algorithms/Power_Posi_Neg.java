package com.HackerRank.Algorithms;

/**
 * Created by Manoj.Mohanan Nair on 7/14/2017.
 */
public class Power_Posi_Neg {

    public static void main(String[] args) {

        float x = 3;
        //int y =-3;
        int y = 6;
        float val = power(x, y);
        System.out.println("value of" + val);

    }

    private static float power(float x, int y) {
        float temp;
        if (y == 0)
            return 1;
        temp = power(x, y / 2);
        if (y % 2 == 0)
            return temp * temp;
        else {
            if (y > 0)
                return x * temp * temp;
            else
                return (temp * temp) / x;
        }
    }
}
