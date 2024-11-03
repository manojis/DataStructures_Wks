package com.leetcode;

public class LongestSubstringOptimized {

    public static int longestValidSubstring(String s) {
        int n = s.length();
        if (n < 2) return 0; // No valid substring if length is less than 2

        // Arrays to track the first and last occurrences of each character
        int[] firstIndex = new int[26];
        int[] lastIndex = new int[26];

        // Initialize arrays with default values
        for (int i = 0; i < 26; i++) {
            firstIndex[i] = -1;
            lastIndex[i] = -1;
        }

        // Populate first and last indices for each character
        for (int i = 0; i < n; i++) {
            int charIndex = s.charAt(i) - 'a';
            if (firstIndex[charIndex] == -1) {
                firstIndex[charIndex] = i;
            }
            lastIndex[charIndex] = i;
        }

        int maxLength = 0;

        // Check each character's first and last occurrence
        for (int i = 0; i < 26; i++) {
            if (firstIndex[i] != -1) {
                for (int j = i + 1; j < 26; j++) {
                    if (lastIndex[j] != -1 && firstIndex[i] < lastIndex[j]) {
                        int length = lastIndex[j] - firstIndex[i] + 1;
                        maxLength = Math.max(maxLength, length);
                    }
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcda";
        int result = longestValidSubstring(s);
        System.out.println("Length of the longest valid substring: " + result);
    }
}
