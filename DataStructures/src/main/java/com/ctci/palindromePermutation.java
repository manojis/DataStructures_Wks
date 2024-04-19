package com.ctci;

import java.util.HashMap;
import java.util.Map;

public class palindromePermutation {
    public static void main(String[] args) {
        boolean x = canPermutePalindrome("aa");
        System.out.println("x: " +x);
    }

    public static boolean canPermutePalindrome(String s) {
        int[] map = new int[128];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
            if (map[s.charAt(i)] % 2 == 0)
                count--;
            else
                count++;
        }
        return count <= 1;
    }
    public static boolean mySolution(String s) {
        if (s.length() % 2 == 0) {
            return false;
        }

        Map<Character, Integer> cMap = new HashMap();
        int val = 0;
        for(int i = 0; i<s.length(); i++) {
            char x = s.charAt(i);
            if (cMap.containsKey(x)) {
                val--;
                cMap.remove(x);
            } else {
                cMap.put(x, 1);
                val++;
            }
        }
        if (val != 1) {
            return false;
        }
        return true;
    }
}
