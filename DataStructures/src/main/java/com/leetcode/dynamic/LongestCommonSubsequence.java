package com.leetcode.dynamic;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        LongestCommonSubsequence ls = new LongestCommonSubsequence();
        System.out.println(ls.longestCommonSubsequence("abcde", "ace"));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        char[] cText1 = text1.toCharArray();
        char[] cText2 = text2.toCharArray();
        int[][] output = new int[cText1.length+1][cText2.length+1];

        // if the length of either string is zero
        if (cText1.length == 0 || cText2.length == 0) {
            return 0;
        }

        for (int i = 0; i< cText1.length; i++) {
            output[i][0] = 0;
        }

        for (int i = 0; i< cText2.length; i++) {
            output[0][i] = 0;
        }

        for (int i = 1; i<= cText1.length; i++) {
            for (int j = 1; j <= cText2.length; j++) {
                // if the characters are the same
                if(cText1[i-1] == cText2[j-1]) {
                    output[i][j] = output[i-1][j-1] + 1;
                } else {
                    output[i][j] = Math.max(output[i][j-1], output[i-1][j]);
                }
            }
        }
        return output[cText1.length][cText2.length];
    }
}
