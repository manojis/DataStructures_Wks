package com.ctci;

public class ChartoAscii {
    public static void main(String[] args){
        char x = 'b';
        System.out.println("value: "+(int)x);
        int[] xd = new int[256];
        for(int xe : xd){
            System.out.println(xe);
        }

        String s = "words";
        int test = 0;
        for (int i= 0; i< s.length(); i++) {
            test = s.charAt(i);
            System.out.println("x is: "+ test);
        }
    }
}