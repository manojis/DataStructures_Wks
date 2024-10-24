package com.algo6515.HW6515;

/**
 * Given two strings X = x1; x2; : : : ; xn and Y = y1; y2; : : : ; ym
 * Give a dynamic programming algorithm to find the length k of the longest string Z = z1; : : : ; zk
 * where Z appears as a substring of X and as a subsequence of Y.
 * Recall, a substring is consecutive elements.
 * For example, for the following input:
 * X = a; b; d; b; a; b; f; g; d
 * Y = b; e; t; f; d; b; f; a; f; r
 * then the answer is 4 (since, b; d; b; a is a substring of X and it is also a subsequence of Y). You do
 * not need to output the actual substring, just its length.
 */
public class SubstringAndSubsequence_1143 {

    static final int MAX = 1000;

    public static void main(String[] args)
    {
        /** char x[] = "ABCD".toCharArray();
        char y[] = "BACDBDCD".toCharArray();*/

        char x[] = "abdbabfgd".toCharArray();
        char y[] = "betfdbfafr".toCharArray();

        int n = x.length, m = y.length;
        System.out.println(maxSubsequenceSubstring(x, y, n, m));
    }
    // Return the maximum size of substring of
    // X which is substring in Y.
    static int maxSubsequenceSubstring(char x[], char y[],
                                       int n, int m)
    {
        int dp[][] = new int[MAX][MAX];
        int max_val = 0;

        // Initialize the dp[][] to 0.
        for (int i = 0; i <= m; i++)
            for (int j = 0; j <= n; j++)
                dp[i][j] = 0;

        // Calculating value for each element.
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                // If alphabet of string X and Y are
                // equal make dp[i][j] = 1 + dp[i-1][j-1]
                if (x[j - 1] == y[i - 1])
                    dp[i][j] = 1 + dp[i - 1][j - 1];

                    // Else copy the previous value in the
                    // row i.e dp[i-1][j-1]
                else
                    dp[i][j] = dp[i-1][j];

                if (dp[i][j] > max_val) {
                    max_val = dp[i][j];
                }
            }
        }

        // Finding the maximum length.
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            ans = Math.max(ans, dp[i][n]);
        }

        return max_val;
    }
}
