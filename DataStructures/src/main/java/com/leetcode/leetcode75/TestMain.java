package com.leetcode.leetcode75;

import java.util.ArrayList;

public class TestMain {
    public static void main(String[] args) {
        String output = fibonacci(8);
        System.out.println("Hello World!"+output);
    }
    private static String fibonacci(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(3);
        result.add(5);
        result.add(1);
        result.add(10);
        StringBuilder sb = new StringBuilder();
        for(int i = (result.size()-1); i>=0 ; i--) {
            sb.append(result.get(i));
        }
        return sb.toString();
    }
}
