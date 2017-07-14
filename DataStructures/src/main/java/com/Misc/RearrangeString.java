package com.Misc;

/**
 * Created by 212561694 on 6/1/2017.
 */
public class RearrangeString {

    static final int MAX_CHAR = 26;

    // Method to return string in lexicographic
    // order followed by integers sum
    static String arrangeString(String str) {
        int char_count[] = new int[MAX_CHAR];
        int sum = 0;

        // Traverse the string
        for (int i = 0; i < str.length(); i++) {
            // Count occurrence of uppercase alphabets
            //char_count contains all alphabets count in increasing order
            //each position is in increasing order
            if (Character.isUpperCase(str.charAt(i))) {
                System.out.println(str.charAt(i) - 'A');
                char_count[str.charAt(i) - 'A']++;
            }
            //Store sum of integers
            else {
                System.out.println(str.charAt(i) - '0');
                sum = sum + (str.charAt(i) - '0');
            }
        }
        String res = "";
        // Traverse for all characters A to Z
        for (int i = 0; i < MAX_CHAR; i++) {
            char ch = (char) ('A' + i);
            System.out.println("ch ------------>" + ch);
            // Append the current character
            // in the string no. of times it
            //  occurs in the given string
            while (char_count[i]-- != 0) {
                res = res + ch;
                System.out.println("res ---------->" + res);
            }
        }
        // Append the sum of integers
        if (sum > 0)
            res = res + sum;
        // return resultant string
        return res;
    }

    // Driver method
    public static void main(String args[]) {
        String str = "ACCBA10D2EW30";
        System.out.println(arrangeString(str));
    }
}
