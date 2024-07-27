package com.ctci;

public class Q1_5_OneAway {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        boolean val = oneAway("pale", "ple");
        System.out.println(val);
    }
    private static boolean oneAway(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 == len2) {
            return oneEditReplace(word1, word2);
        } else if (len1 + 1 == len2) {
            return oneEditInsert(word1, word2);
        } else if (len1 - 1 == len2) {
            return oneEditInsert(word2, word1);
        }
        return false;
    }
    private static boolean oneEditReplace(String word1, String word2) {
        boolean foundDifference = false;
        for (int i=0; i<word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }
    private static boolean oneEditInsert(String word1, String word2) {
        int index1 = 0;
        int index2 = 0;
        while (index2 < word2.length() && index1 < word1.length()) {
            if (word1.charAt(index1) != word2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }
}
