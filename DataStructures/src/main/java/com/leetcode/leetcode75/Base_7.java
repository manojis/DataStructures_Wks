package com.leetcode.leetcode75;

import java.util.ArrayList;

public class Base_7 {
    public static void main(String[] args) {
        int num = -7;
        Base_7 bs = new Base_7();
        System.out.println(bs.convertToBase7(num));
    }
    private ArrayList<Integer> result = new ArrayList<>();

    public String convertToBase7(int num) {

        String result = "";
        boolean flag = false;
        // if the number is 0, return 0 as string;
        if (num == 0) {
            return result + "0";
        }

        // if the num is less than zero, prepend "-" later
        if (num < 0) {
            flag = true;
            num = num * -1;
        }

        while (num >= 7) {
            result = (num%7) + result;
            num = num/7;
            convertToBase7(num);
        }
        if(num > 0) {
            result = (num%7) + result;
        }
        if (flag) {
            result = "-" + result;
        }
        return result;
        //return Integer.toString(num, 7);
    }
}
