package com.algo6515.HW6515;

/**
 * We call a sequence of alphabetical characters symmetric if it reads the same backwards as it does
 * forwards. An example of a symmetric sequence is r; a; c; e; c; a; r. An example of a sequence that is
 * not symmetric is a; b; c; d; a.
 * Design a dynamic programming algorithm that takes as input a sequence of alphabetical characters
 * A of length n and returns the length of the longest symmetric subsequence of A. Note that this
 * subsequence is not necessarily contiguous.
 * Example:
 * Input: A = a; b; c; d; a; f
 * Output: 3
 * Explanation: a; c; a is longest symmetrikc subsequence of A.
 * https://www.youtube.com/watch?v=TLaGwTnd3HY
 */
public class LongestPalindrome {
    public static void main(String[] args){
        LongestPalindrome l = new LongestPalindrome();
        System.out.println(l.longestPalindromeSubseq("ACGTGTCAAAATCG"));
    }
    /*public int longestPalindromeSubseq(String s) {

        int size=s.length();
        int[][] dp = new int[size][size];
        for(int i=size-1;i>=0;i--){
            dp[i][i]=1;
            for(int j=i+1;j<size;j++){
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i+1][j-1]+2;
                }else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][size-1];
    }*/
    public int longestPalindromeSubseq(String s) {
        // create a matrix.
        int[][] d = new int[s.length()][s.length()];

        // populate initial states.
        for (int i = 0; i < s.length(); i++) {
            d[i][i] = 1;
        }

        // iterate through length of substring.
        for (int len = 1; len < s.length(); len++) {
            // iterate through i from 0 to s.length - len
            for (int i = 0; i < s.length() - len; i++) {

                int j = i + len;

                if (s.charAt(i) == s.charAt(j)) {
                    d[i][j] = d[i+1][j-1] + 2;
                } else {
                    d[i][j] = Math.max(d[i+1][j], d[i][j-1]);
                }
            }
        }

        // return result matrix[0][s.length-1]
        return d[0][s.length() - 1];
    }
}
