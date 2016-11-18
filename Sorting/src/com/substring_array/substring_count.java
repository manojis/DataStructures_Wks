package com.substring_array;

import java.util.Scanner;
/**
 * Created by 212561694 on 10/19/2016.
 */
public class substring_count {

    public static void main(String[] args) {

        String x = "0";
        String y = "1";
        for(int i=0;i< 20;i++){

            String v = (x+y);
            x = x+"0";
            y = "1" + y;

            System.out.println(v);
        }

        String a = "1";
        String b = "0";
        for(int j=0;j< 20;j++){

            String u = (a+b);
            b = b +"0";
            a = "1" + a;
            System.out.println(u);
        }
    }
}
